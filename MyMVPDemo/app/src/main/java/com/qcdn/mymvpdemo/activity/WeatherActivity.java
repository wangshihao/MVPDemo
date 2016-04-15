package com.qcdn.mymvpdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.qcdn.mymvpdemo.R;
import com.qcdn.mymvpdemo.model.bean.WeatherBean;
import com.qcdn.mymvpdemo.presenter.WeatherPresenter;
import com.qcdn.mymvpdemo.view.WeatherView;

/**
 * Created by wsh on 2016/3/22.
 */
public class WeatherActivity extends Activity implements WeatherView {

    private android.widget.TextView text;
    private android.widget.ProgressBar mProgressBar;
    private android.widget.Button button;
    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherPresenter = new WeatherPresenter(this);

        this.button = (Button) findViewById(R.id.button);
        this.mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        this.text = (TextView) findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherPresenter.load();
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
    public void loadSuccess(WeatherBean weatherBean) {
        text.setText(weatherBean.getCity() + weatherBean.getTime() + weatherBean.getWd());
    }

    @Override
    public void loadError(String msg) {
        Toast.makeText(WeatherActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
