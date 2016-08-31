package com.ligeirostudio.examplen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Fernando on 8/28/16.
 */

public class Contact implements Serializable{

    private int id;
    private String name;
    private String phone;
    private String photo;

    public Contact(int id, String name, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.photo = photo;
    }

    public Contact(){
    }

    public List <Contact> getListOfContact(){

        List list = new ArrayList();
        list.add(new Contact(0,"Fenando Costa", "(11) 99999-9999", "file:///android_asset/photo_color.jpg"));
        list.add(new Contact(1,"Fenando Costa", "(11) 99999-9999", "file:///android_asset/photo_color.jpg"));
        list.add(new Contact(2,"Jussara Macedo", "(11) 98888-9999","file:///android_asset/photo.jpg"));
        list.add(new Contact(3,"Jorge Vercilo", "(11) 97777-9999","file:///android_asset/profile.jpg"));


        return list;
    }

    public Contact findContact(int id) {
        for(Contact contact : getListOfContact()) {
            if(contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    public Contact findContact(int id, List<Contact> list) {
        for(Contact contact : list) {
            if(contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
