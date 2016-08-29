package com.ligeirostudio.examplen.model;

import java.io.Serializable;

/**
 * Created by Fernando on 8/28/16.
 */

public class Contact implements Serializable{

    private String id;
    private String name;
    private String phone;
    private String photo;

    public Contact(String id, String name, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.photo = photo;
    }

    public Contact() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
