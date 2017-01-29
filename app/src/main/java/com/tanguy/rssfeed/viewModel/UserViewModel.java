package com.tanguy.rssfeed.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.RSSFeedApplication;
import com.tanguy.rssfeed.model.User;
import com.tanguy.rssfeed.service.CallBackAuthenticate;
import com.tanguy.rssfeed.service.RetrofitFactory;
import com.tanguy.rssfeed.view.activity.SignupActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserViewModel implements CallBackAuthenticate {
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

    public void authenticateSuccess(JSONObject res) {
        try {
            // Set token in Shared Preferences
            sharedPreferences.edit()
                    .putString("token", res.getString("token"))
                    .apply();
            // Go back to main Activity, job is finish
            renderMainActivity();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void authenticateError(JSONObject res) {
        try {
            Toast.makeText(context, res.getString("message"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void login(View view) {
        // Validate user before try login
        if (user.loginValidation()) {
            retrofitFactory.loginUser(this, user);
        } else {
            Snackbar.make(view, R.string.missingParameters, Snackbar.LENGTH_LONG)
                    .setDuration(Snackbar.LENGTH_SHORT).show();
        }
    }

    public void signup(View view) {
        // Validate user before try signup
        if (user.signupValidation(passwordConfirmation)) {
            if (user.comparePasswords(user.password, passwordConfirmation)) {
                retrofitFactory.signupUser(this, user);
            } else {
                Snackbar.make(view, R.string.passwordConfirmationError, Snackbar.LENGTH_LONG)
                        .setDuration(Snackbar.LENGTH_SHORT).show();
            }
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

    private void renderMainActivity() {
        // Finish LoginActivity to go back to MainActivity
        if (context instanceof Activity) {
            Intent returnIntent = new Intent();
            ((Activity) context).setResult(Activity.RESULT_OK, returnIntent);
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
