package com.ligeirostudio.examplen.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Fernando on 8/30/16.
 */
public class Transfers implements Serializable {

    @SerializedName("Id")
    private int id;

    @SerializedName("ClienteId")
    private int clientId;

    @SerializedName("Valor")
    private double value;

    @SerializedName("Token")
    private String token;

    @SerializedName("Data")
    private String date;

    public Transfers(int id, int clientId, double value, String token, String date) {
        this.id = id;
        this.clientId = clientId;
        this.value = value;
        this.token = token;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
