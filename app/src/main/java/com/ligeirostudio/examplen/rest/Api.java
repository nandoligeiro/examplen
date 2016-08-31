package com.ligeirostudio.examplen.rest;

import com.ligeirostudio.examplen.model.SendMoney;
import com.ligeirostudio.examplen.model.Transfers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Fernando on 8/29/16.
 */

public interface Api {

    @GET("/GenerateToken")
    Call<String> generateToken(@Query("nome") String name, @Query("email") String email);

    @POST("/SendMoney")
    Call<String> postSendMoney(@Body SendMoney sendMoney);

    @GET("/GetTransfers")
    Call<List<Transfers>> getTransfers(@Query("token") String token);
}
