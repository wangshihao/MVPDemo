package com.qcdn.mymvpdemo.presenter;

import android.content.Context;

import com.qcdn.mymvpdemo.adpter.WeatherAdapter;
import com.qcdn.mymvpdemo.model.WeatherModel;
import com.qcdn.mymvpdemo.model.bean.WeatherBean;
import com.qcdn.mymvpdemo.view.NewWeatherView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsh on 2016/3/22.
 */
public class NewWeatherPresenter implements WeatherListener {
    private final WeatherModel weatherModel;
    public NewWeatherView newWeatherView;
    private Context context;
    private List<String> lists = new ArrayList<>();
    private final WeatherAdapter weatherAdapter;

    public NewWeatherPresenter(NewWeatherView newWeatherView, Context context) {
        this.newWeatherView = newWeatherView;
        this.context = context;
        weatherAdapter = new WeatherAdapter(context, lists);
        weatherModel = new WeatherModel();
    }

    public void initData() {
        newWeatherView.showDialog();
        weatherModel.loadData(this);
    }

    public void initRefresh() {
        if (!lists.isEmpty()) {
            lists.clear();
        }
        weatherModel.loadData(this);
    }

    @Override
    public void success(WeatherBean weatherBean) {
        String wd = weatherBean.getWd();
        String time = weatherBean.getTime();
        String city = weatherBean.getCity();
        String ws = weatherBean.getWs();
        lists.add(wd);
        lists.add(time);
        lists.add(city);
        lists.add(ws);
        lists.add(wd);
        lists.add(time);
        lists.add(city);
        lists.add(ws);
        newWeatherView.loadSuccess(weatherAdapter, lists);
        newWeatherView.initHeader(city);
        newWeatherView.dismissDialog();
    }

    @Override
    public void error(String msg) {
        newWeatherView.loadError(msg);
        newWeatherView.dismissDialog();
    }
}
