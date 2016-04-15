package com.qcdn.mymvpdemo.presenter;

import com.qcdn.mymvpdemo.model.bean.WeatherBean;

/**
 * Created by wsh on 2016/3/22.
 */
public interface WeatherListener {
    void success(WeatherBean weatherBean);

    void error(String msg);
}
