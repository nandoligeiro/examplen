package com.ligeirostudio.examplen.model;

import java.io.Serializable;

/**
 * Created by Fernando on 8/30/16.
 */
public class SendMoney implements Serializable{

    private int clientId;
    private double value;
    private String token;

    public SendMoney(int clientId, double value, String token) {
        this.clientId = clientId;
        this.value = value;
        this.token = token;
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
}
