package com.qcdn.mymvpdemo.view;

import com.qcdn.mymvpdemo.model.bean.WeatherBean;

/**
 * Created by wsh on 2016/3/22.
 */
public interface WeatherView {
    void showDialog();

    void dismissDialog();

    void loadSuccess(WeatherBean weatherBean);

    void loadError(String msg);
}
