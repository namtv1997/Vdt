package com.vpdt.vpdt.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String TAG = "RetrofitClient";
    private static Retrofit retrofit = null;


    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient(){
        TokenAuthenticator tokenAuthenticator = new TokenAuthenticator();

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(100);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(3000, TimeUnit.SECONDS)
                .readTimeout(1500, TimeUnit.SECONDS)
                .writeTimeout(1500, TimeUnit.SECONDS);
        httpClient.authenticator(tokenAuthenticator);
        httpClient.addInterceptor(logging);
        httpClient.dispatcher(dispatcher);

        return httpClient.build();
    }

}
