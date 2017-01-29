package com.tanguy.rssfeed.service;

import org.json.JSONObject;

public interface CallBackInterface {
    void authenticateSuccess(JSONObject token);

    void authenticateError(JSONObject token);
}
