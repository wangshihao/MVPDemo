package com.qcdn.mymvpdemo.presenter;

import com.qcdn.mymvpdemo.model.WeatherModel;
import com.qcdn.mymvpdemo.model.bean.WeatherBean;
import com.qcdn.mymvpdemo.view.WeatherView;

/**
 * Created by wsh on 2016/3/22.
 */
public class WeatherPresenter implements WeatherListener {
    public WeatherView weatherView;
    private final WeatherModel weatherModel;

    public WeatherPresenter(WeatherView weatherView) {
        this.weatherView = weatherView;
        weatherModel = new WeatherModel();
    }

    public void load() {
        weatherView.showDialog();
        weatherModel.loadData(this);
    }

    @Override
    public void success(WeatherBean weatherBean) {
        weatherView.dismissDialog();
        weatherView.loadSuccess(weatherBean);
    }

    @Override
    public void error(String msg) {
        weatherView.dismissDialog();
        weatherView.loadError(msg);
    }
}
