package com.qcdn.mymvpdemo.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.qcdn.mymvpdemo.model.bean.WeatherBean;
import com.qcdn.mymvpdemo.presenter.WeatherListener;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wsh on 2016/3/22.
 */
public class WeatherModel implements IWeatherModel {
    public WeatherModel() {

    }

    @Override
    public void loadData(final WeatherListener weatherListener) {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get("http://www.weather.com.cn/adat/sk/101010100.html", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    WeatherBean mainModelBean = new WeatherBean();
                    JSONObject weatherinfo = response.getJSONObject("weatherinfo");
                    mainModelBean.setCity(weatherinfo.getString("city"));
                    mainModelBean.setWd(weatherinfo.getString("WD"));
                    mainModelBean.setWs(weatherinfo.getString("WS"));
                    mainModelBean.setTime(weatherinfo.getString("time"));
                    weatherListener.success(mainModelBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                weatherListener.error(errorResponse.toString());
            }
        });
    }
}
