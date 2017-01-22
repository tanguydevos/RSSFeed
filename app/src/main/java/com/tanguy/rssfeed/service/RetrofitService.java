package com.tanguy.rssfeed.service;

import com.tanguy.rssfeed.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {
    @POST("post")
    Call<String> fetchToken(@Body User user);
}