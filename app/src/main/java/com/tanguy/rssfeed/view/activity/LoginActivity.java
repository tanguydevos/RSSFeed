package com.tanguy.rssfeed.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.databinding.LoginActivityBinding;
import com.tanguy.rssfeed.viewModel.UserViewModel;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        LoginActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        UserViewModel userViewModel = new UserViewModel(this);
        binding.setUserViewModel(userViewModel);
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

}
