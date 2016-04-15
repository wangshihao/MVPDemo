package com.qcdn.mymvpdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.qcdn.mymvpdemo.R;
import com.qcdn.mymvpdemo.presenter.LoginPresenter;
import com.qcdn.mymvpdemo.view.LoginView;

public class MainActivity extends Activity implements LoginView {

    private android.widget.EditText etname;
    private android.widget.EditText etpassword;
    private android.widget.Button btnlogin;
    private android.widget.ProgressBar mProgressBar;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        this.btnlogin = (Button) findViewById(R.id.btn_login);
        this.etpassword = (EditText) findViewById(R.id.et_password);
        this.etname = (EditText) findViewById(R.id.et_name);

        loginPresenter = new LoginPresenter(this, this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login();
            }
        });
    }

    @Override
    public void successModify(String msg) {
        finish();
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorModify(String msg) {
        Intent intent = new Intent(MainActivity.this, NewWeatherActivity.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissDialog() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public String getName() {
        return etname.getText().toString();
    }

    @Override
    public String getPassword() {
        return etpassword.getText().toString();
    }
}
