package com.qcdn.mymvpdemo.presenter;

import android.content.Context;
import android.widget.Toast;

import com.qcdn.mymvpdemo.model.LoginModel;
import com.qcdn.mymvpdemo.view.LoginView;

/**
 * Created by wsh on 2016/3/22.
 */
public class LoginPresenter implements LoginListener {
    public LoginView loginView;
    private final LoginModel loginModel;
    private Context context;

    public LoginPresenter(LoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;
        loginModel = new LoginModel();
    }

    public void login() {
        String name = loginView.getName();
        String password = loginView.getPassword();
        if (name.equals("") || password.equals("")) {
            Toast.makeText(context, "name or pass 不能是空", Toast.LENGTH_SHORT).show();
        } else {
            loginView.showDialog();
            loginModel.login(name, password, this);
        }
    }

    @Override
    public void onSucess(String msg) {
        loginView.dismissDialog();
        loginView.successModify(msg);
    }

    @Override
    public void onError(String msg) {
        loginView.dismissDialog();
        loginView.errorModify(msg);
    }
}
