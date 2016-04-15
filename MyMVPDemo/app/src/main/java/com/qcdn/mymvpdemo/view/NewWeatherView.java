package com.qcdn.mymvpdemo.view;

import com.qcdn.mymvpdemo.adpter.WeatherAdapter;

import java.util.List;

/**
 * Created by wsh on 2016/3/22.
 */
public interface NewWeatherView {
    void showDialog();

    void dismissDialog();

    void loadSuccess(WeatherAdapter weatherAdapter,List<String> lists);

    void loadError(String msg);

    void initHeader(String msg);

}
