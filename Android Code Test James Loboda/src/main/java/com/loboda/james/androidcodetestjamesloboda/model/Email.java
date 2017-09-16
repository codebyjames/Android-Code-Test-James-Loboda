package com.loboda.james.androidcodetestjamesloboda.model;

import io.realm.RealmObject;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class Email extends RealmObject {

    private String email;

    public Email(){

    }

    public void setValues(String email) {
        this.email = email;
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
