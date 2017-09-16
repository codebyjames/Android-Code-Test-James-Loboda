package com.loboda.james.androidcodetestjamesloboda.model;

import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;

import io.realm.RealmObject;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class Phone extends RealmObject {

    private String type;
    private long number;

    public Phone() {
        this.type = HelperPhoneLabels.TYPE_MOBILE;
    }

    public Phone(long number) {
        this.number = number;
        this.type = HelperPhoneLabels.TYPE_MOBILE;
    }

    public Phone(long number, String type) {
        this.number = number;
        this.type = type;
    }

    public void setValues(long number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
