package com.tanguy.rssfeed.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.model.User;
import com.tanguy.rssfeed.service.CallBackInterface;
import com.tanguy.rssfeed.service.RetrofitFactory;
import com.tanguy.rssfeed.view.activity.SignupActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserViewModel implements CallBackInterface {
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

    public void loginSuccess() {
        System.out.println("I've been called back");
    }

    public void loginError() {
        System.out.println("I've been called back error");
    }

    public void signupSuccess(JSONObject res) {
        try {
            Log.d(TAG, res.toString());
            Log.d(TAG, res.getString("token"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void signupError(JSONObject res) {
        System.out.println("I've been called back error");
    }

    public void login(View view) {
        if (user.loginValidation()) {
            Log.d(TAG, user.login);
            retrofitFactory.loginUser(this, user);
            sharedPreferences.edit().putString(context.getString(R.string.token), "token").apply();
            renderMainActivity();
        } else {
            Log.e(TAG, "Missing parameters");
        }
    }

    public void signup(View view) {
        if (user.signupValidation(passwordConfirmation)) {
            if (!user.comparePasswords(user.password, passwordConfirmation)) {
                Snackbar.make(view, R.string.passwordConfirmationError, Snackbar.LENGTH_LONG)
                        .setDuration(Snackbar.LENGTH_SHORT).show();
            }
//            retrofitFactory.signupUser(this, user);
        } else {
            Snackbar.make(view, R.string.missingParameters, Snackbar.LENGTH_LONG)
                    .setDuration(Snackbar.LENGTH_SHORT).show();
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

    void renderMainActivity() {
        // Finish LoginActivity to go back to MainActivity
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
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
}
