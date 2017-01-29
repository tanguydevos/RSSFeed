package com.tanguy.rssfeed.service;

import org.json.JSONObject;

public interface CallBackInterface {
    void loginSuccess();

    void loginError();

    void signupSuccess(JSONObject token);

    void signupError(JSONObject token);
}
