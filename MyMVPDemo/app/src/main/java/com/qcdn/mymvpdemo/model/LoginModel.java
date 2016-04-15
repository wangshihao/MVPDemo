package com.qcdn.mymvpdemo.model;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.qcdn.mymvpdemo.http.HttpUtil;
import com.qcdn.mymvpdemo.presenter.LoginListener;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wsh on 2016/3/22.
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(String name, String pass, final LoginListener loginListener) {
        String url = "";
        RequestParams requestParams = new RequestParams();
        requestParams.put("name", name);
        requestParams.put("password", pass);
        //网络请求
        HttpUtil.post(url, requestParams, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //登录成功
                String json = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    int code = 0;
                    code = jsonObject.getJSONObject("data").getInt("code");
                    //code=0 表示登录成功，code=1表示用户名错误，code=2表示密码错误
                    if (code == 0) {
                        loginListener.onSucess("success");
                    } else if (code == 1) {
                        loginListener.onError("name error");
                    } else if (code == 2) {
                        loginListener.onError("pass error");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                loginListener.onError("error " + statusCode);
            }
        });
    }
}
