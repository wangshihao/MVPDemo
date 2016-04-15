package com.qcdn.mymvpdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.qcdn.mymvpdemo.R;
import com.qcdn.mymvpdemo.adpter.WeatherAdapter;
import com.qcdn.mymvpdemo.presenter.NewWeatherPresenter;
import com.qcdn.mymvpdemo.view.NewWeatherView;

import java.util.List;

/**
 * ListView刷新以及下拉刷新
 * Created by wsh on 2016/3/22.
 */
public class NewWeatherActivity extends Activity implements NewWeatherView {

    private android.widget.ListView activityguidescenicelistview;
    private android.support.v4.widget.SwipeRefreshLayout activityguidescenicerefresh;
    private NewWeatherPresenter newWeatherPresenter;
    private android.widget.ProgressBar mProgressBar;
    private WeatherAdapter weatherAdapter;
    private List<String> lists;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_weather);

        this.mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        this.activityguidescenicerefresh = (SwipeRefreshLayout) findViewById(R.id.activity_guide_scenice_refresh);
        this.activityguidescenicelistview = (ListView) findViewById(R.id.activity_guide_scenice_listview);

        headerView = View.inflate(this, R.layout.header_view, null);
        activityguidescenicelistview.addHeaderView(headerView);

        // presenter 传入参数(NewWeatherView，context)
        newWeatherPresenter = new NewWeatherPresenter(this, this);
        //请求数据的方法
        newWeatherPresenter.initData();

        activityguidescenicerefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newWeatherPresenter.initRefresh();
                activityguidescenicerefresh.setRefreshing(false);
            }
        });
        activityguidescenicelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NewWeatherActivity.this, lists.get(position) + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showDialog() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissDialog() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loadSuccess(WeatherAdapter weatherAdapter, List<String> lists) {
        this.lists = lists;
        this.weatherAdapter = weatherAdapter;
        activityguidescenicelistview.setAdapter(weatherAdapter);
        weatherAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadError(String msg) {

    }

    @Override
    public void initHeader(String msg) {
        TextView headerTv = (TextView) headerView.findViewById(R.id.header_tv);
        headerTv.setText(msg);
    }
}
