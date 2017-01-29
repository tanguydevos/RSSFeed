package com.tanguy.rssfeed.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.model.User;
import com.tanguy.rssfeed.service.RetrofitFactory;
import com.tanguy.rssfeed.view.activity.SignupActivity;

public class UserViewModel {
    private static final String TAG = "UserViewModel";
    private Context context;
    private String passwordConfirmation;
    private User user;
    private RetrofitFactory retrofitFactory = RSSFeedApplication.getInstance().getRetrofitFactory();
    private SharedPreferences sharedPreferences = RSSFeedApplication.getInstance().getSharedPreferences();


    public UserViewModel(Context context) {
        this.context = context;
        this.user = new User();
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
        if (user.loginValidation()) {
            Log.d(TAG, user.login);
//            retrofitFactory.loginUser(user);
            sharedPreferences.edit().putString(context.getString(R.string.token), "token").apply();
            renderMainActivity();
        } else {
            Log.e(TAG, "Missing parameters");
        }
    }

    public void signup(View view) {
        if (user.signupValidation(passwordConfirmation)) {
//            retrofitFactory.signupUser(user);
        } else {
            Log.e(TAG, "Missing parameters");
        }
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

    public void renderMainActivity() {
        // Finish Signup activity to go back to LoginActivity
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
