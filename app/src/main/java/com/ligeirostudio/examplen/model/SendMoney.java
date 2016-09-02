package com.ligeirostudio.examplen.model;

import java.io.Serializable;

/**
 * Created by Fernando on 8/30/16.
 */
public class SendMoney implements Serializable{

    private int Id;
    private int ClienteId;
    private double Valor;
    private String Token;
    private String Data;

    public SendMoney(int id, int clienteId, double valor, String token, String data) {
        Id = id;
        ClienteId = clienteId;
        Valor = valor;
        Token = token;
        Data = data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int clienteId) {
        ClienteId = clienteId;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
