package com.tanguy.rssfeed.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tanguy.rssfeed.R;
import com.tanguy.rssfeed.databinding.SignupActivityBinding;
import com.tanguy.rssfeed.model.User;
import com.tanguy.rssfeed.viewModel.UserViewModel;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        SignupActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.signup_activity);
        User user = new User();
        UserViewModel userViewModel = new UserViewModel(this, user);
        binding.setUserViewModel(userViewModel);
    }
}
