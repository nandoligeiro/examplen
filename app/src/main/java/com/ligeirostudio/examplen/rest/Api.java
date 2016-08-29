package com.ligeirostudio.examplen.rest;

import com.ligeirostudio.examplen.model.GenerateToken;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Fernando on 8/29/16.
 */

public interface Api {


    @GET("/GenerateToken")
    Call<String> generateToken(@Query("nome") String name, @Query("email") String email);
}
