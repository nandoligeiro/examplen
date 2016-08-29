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


    private EventBus mBus;

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()) {
            Log.e("RESPONSE", " " + response.body());

            mBus.getDefault().postSticky(response.body());

        } else {
            mBus.getDefault().postSticky(response.errorBody());

        }


    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("Listener_error", " " + t.getMessage());

        mBus.getDefault().postSticky(t.getMessage());

    }


}