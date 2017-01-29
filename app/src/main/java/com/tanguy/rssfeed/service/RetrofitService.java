package com.tanguy.rssfeed.service;

import com.tanguy.rssfeed.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface RetrofitService {
    // Users routes and endpoints
    @POST("users/authenticate")
    Call<ResponseBody> loginUser(@Body User user);

    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> signupUser(@Field("login") String login, @Field("password") String password);
}