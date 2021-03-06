package com.tanguy.rssfeed.service;

import com.tanguy.rssfeed.model.Channel;
import com.tanguy.rssfeed.model.Feed;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

interface RetrofitService {
    // Users routes and endpoints
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginUser(@Field("login") String login, @Field("password") String password);

    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> signupUser(@Field("login") String login, @Field("password") String password);

    // Channels routes and endpoints
    @GET("channels")
    Call<List<Channel>> getChannels(@Query("token") String token);

    @GET
    Call<List<Feed>> getChannel(@Url String url);

    @FormUrlEncoded
    @POST("rss/new")
    Call<ResponseBody> addChannel(@Field("token") String token, @Field("rssUrl") String url);

}