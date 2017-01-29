package com.tanguy.rssfeed.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface RetrofitService {
    // Users routes and endpoints
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginUser(@Field("login") String login, @Field("password") String password);

    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> signupUser(@Field("login") String login, @Field("password") String password);
}