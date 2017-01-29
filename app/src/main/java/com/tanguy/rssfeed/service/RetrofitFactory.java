package com.tanguy.rssfeed.service;

import android.util.Log;

import com.tanguy.rssfeed.model.Channel;
import com.tanguy.rssfeed.model.Feed;
import com.tanguy.rssfeed.model.User;
import com.tanguy.rssfeed.viewModel.AddChannelViewModel;
import com.tanguy.rssfeed.viewModel.ChannelViewModel;
import com.tanguy.rssfeed.viewModel.FeedViewModel;
import com.tanguy.rssfeed.viewModel.UserViewModel;

import org.json.JSONObject;

import java.util.List;
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
    private final static String BASE_URL = "https://javale.herokuapp.com/";

    private RetrofitService service;

    public RetrofitFactory() {
        // Init the HTTP client to make requests on the API
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        // Retrofit will help us to perform easier HTTP requests / responses
        // We use JacksonConverter to get JSON through API's responses
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);
    }

    // Attempt to login the user
    public void loginUser(final UserViewModel userViewModel, User user) {
        Call<ResponseBody> call = service.loginUser(user.login, user.password);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, response.raw().toString());
                try {
                    JSONObject res = new JSONObject(response.body().string());
                    if (response.isSuccessful()) {
                        userViewModel.authenticateSuccess(res);
                    } else {
                        userViewModel.authenticateError(res);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    // Attempt to signup the guest
    public void signupUser(final UserViewModel userViewModel, User user) {
        Call<ResponseBody> call = service.signupUser(user.login, user.password);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, response.raw().toString());
                try {
                    JSONObject res = new JSONObject(response.body().string());
                    if (response.isSuccessful()) {
                        userViewModel.authenticateSuccess(res);
                    } else {
                        userViewModel.authenticateError(res);
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

    // Attempt to get channels from API
    public void getChannels(final ChannelViewModel channelViewModel, String token) {
        Log.d(TAG, token);
        Call<List<Channel>> call = service.getChannels(token);
        call.enqueue(new Callback<List<Channel>>() {

            @Override
            public void onResponse(Call<List<Channel>> call, Response<List<Channel>> response) {
                Log.d(TAG, response.raw().toString());
                try {
                    if (response.isSuccessful()) {
                        channelViewModel.getChannelsSuccess(response.body());
                    } else {
                        channelViewModel.getChannelsError(response.body());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Channel>> call, Throwable t) {
                Log.d(TAG, call.toString());
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void getChannel(final FeedViewModel feedViewModel, int id) {
        Call<List<Feed>> call = service.getChannel("channels/" + id + "/items");
        call.enqueue(new Callback<List<Feed>>() {

            @Override
            public void onResponse(Call<List<Feed>> call, Response<List<Feed>> response) {
                Log.d(TAG, response.raw().toString());
                try {
                    if (response.isSuccessful()) {
                        feedViewModel.getFeedsSuccess(response.body());
                    } else {
                        feedViewModel.getFeedsError(response.body());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Feed>> call, Throwable t) {
                Log.d(TAG, call.toString());
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void addChannel(final AddChannelViewModel addChannelViewModel, String token, String url) {
        Log.d(TAG, token);
        Call<ResponseBody> call = service.addChannel(token, url);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, response.raw().toString());
                try {
                    if (response.isSuccessful()) {
                        addChannelViewModel.addSuccess();
                    } else {
                        addChannelViewModel.addError();
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