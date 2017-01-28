package com.tanguy.rssfeed.service;

import com.tanguy.rssfeed.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {
    @POST("users/authenticate")
    Call<ResponseBody> loginUser(@Body User user);

    @POST("users/")
    Call<ResponseBody> signupUser(@Body User user);
}