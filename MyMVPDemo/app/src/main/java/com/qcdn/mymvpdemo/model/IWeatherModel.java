package com.qcdn.mymvpdemo.model;

import com.qcdn.mymvpdemo.presenter.WeatherListener;

/**
 * Created by wsh on 2016/3/22.
 */
public interface IWeatherModel {
    void loadData(WeatherListener weatherListener);
}
