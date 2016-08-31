package com.ligeirostudio.examplen.rest;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by fernandocosta on 2/5/16.
 */
public class RequestCallBack<T> implements Callback<T> {


    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()) {
            Log.e("RESPONSE", " " + response.body());

            EventBus.getDefault().postSticky(response.body());

        } else {
            EventBus.getDefault().postSticky(response.errorBody());

        }


    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("Listener_error", " " + t.getMessage());

        EventBus.getDefault().postSticky(t.getMessage());

    }


}