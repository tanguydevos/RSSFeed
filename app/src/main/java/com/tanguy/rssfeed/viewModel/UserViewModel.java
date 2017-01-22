package com.tanguy.rssfeed.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.tanguy.rssfeed.model.User;
import com.tanguy.rssfeed.service.RetrofitFactory;
import com.tanguy.rssfeed.view.activity.SignupActivity;

public class UserViewModel {
    private static final String TAG = "UserViewModel";
    private Context context;
    private String passwordConfirmation;
    private User user;

    public UserViewModel(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    public String getLogin() {
        return user.login;
    }

    public void setLogin(String login) {
        user.login = login;
    }

    public String getPassword() {
        return user.password;
    }

    public void setPassword(String password) {
        user.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirm) {
        passwordConfirmation = passwordConfirm;
    }

    public void login(View view) {
        if (user.login != null && user.password != null) {
            RetrofitFactory retrofitFactory = new RetrofitFactory();
            retrofitFactory.getToken(user);
        } else {
            Log.e(TAG, "Missing parameters");
        }

    }

    public void signup(View view) {
        Log.d(TAG, user.login);
        Log.d(TAG, user.password);
        Log.d(TAG, passwordConfirmation);
    }

    public void renderSignup(View view) {
        // Start SignupActivity
        Intent intent = new Intent(context, SignupActivity.class);
        context.startActivity(intent);
    }

    public void renderLogin(View view) {
        // Finish Signup activity to go back to LoginActivity
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
