package com.tanguy.rssfeed.service;

import android.util.Log;

import com.tanguy.rssfeed.model.User;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {
    private static final String TAG = "RetrofitFactory";
    private final static String BASE_URL = "http://lightthemup.fr.nf:3000/";
    private RetrofitService service;

    public RetrofitFactory() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);
    }

    public void loginUser(User user) {
        Call<ResponseBody> call = service.loginUser(user);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, response.raw().toString());
                try {
                    if (response.isSuccessful()) {
                        System.out.println(response.body().string());
                    } else {
                        System.out.println(response.errorBody().string());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, call.toString());
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void signupUser(User user) {
        Call<ResponseBody> call = service.signupUser(user);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, response.raw().toString());
                try {
                    if (response.isSuccessful()) {
                        System.out.println(response.body().string());
                    } else {
                        System.out.println(response.errorBody().string());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, call.toString());
                Log.e(TAG, t.getMessage());
            }
        });
    }
}