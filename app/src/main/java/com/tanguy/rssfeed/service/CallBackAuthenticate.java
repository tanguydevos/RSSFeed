package com.tanguy.rssfeed.service;

import org.json.JSONObject;

public interface CallBackAuthenticate {
    void authenticateSuccess(JSONObject token);

    void authenticateError(JSONObject token);
}
