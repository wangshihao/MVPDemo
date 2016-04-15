package com.qcdn.mymvpdemo.model;

import com.qcdn.mymvpdemo.presenter.LoginListener;

/**
 * Created by wsh on 2016/3/22.
 */
public interface ILoginModel {
    void login(String name, String pass, LoginListener loginListener);
}
