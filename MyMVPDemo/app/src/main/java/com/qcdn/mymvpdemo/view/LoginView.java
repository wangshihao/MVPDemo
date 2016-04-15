package com.qcdn.mymvpdemo.view;

/**
 * Created by wsh on 2016/3/22.
 */
public interface LoginView {
    void successModify(String msg);

    void errorModify(String msg);

    void showDialog();

    void dismissDialog();

    String getName();

    String getPassword();
}
