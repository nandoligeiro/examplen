package com.ligeirostudio.examplen.rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ligeirostudio.examplen.model.SendMoney;
import com.ligeirostudio.examplen.model.Transfers;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fernando on 8/29/16.
 */

public class ApiRequester {

    private Api api;

    public ApiRequester() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .create();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Customize the request
                Request request = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("Authorization", "auth-token")
                        .method(original.method(), original.body())
                        .build();

                Response response = chain.proceed(request);

                // Customize or return the response
                return response;
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://processoseletivoneon.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        api = retrofit.create(Api.class);

    }

    public void generateToken(String name, String email){
        api.generateToken(name, email).enqueue(new RequestCallBack<String>());

    }

    public void postSendMoney(SendMoney sendMoney){
        api.postSendMoney(sendMoney).enqueue(new RequestCallBack<String>());
    }

    public void getTransfers(String token){
        api.getTransfers(token).enqueue(new RequestCallBack<List<Transfers>>());
    }

}
