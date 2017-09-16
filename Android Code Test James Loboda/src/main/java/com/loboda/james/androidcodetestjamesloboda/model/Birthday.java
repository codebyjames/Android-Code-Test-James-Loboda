package com.loboda.james.androidcodetestjamesloboda.model;

import io.realm.RealmObject;

/**
 * Created by Twaltex on 9/14/2017.
 */

public class Birthday extends RealmObject {

    private int day;
    private int month;
    private int year;
    private String date;

    public Birthday(){

    }

    public Birthday(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        date = String.valueOf(month) + String.valueOf(day) + String.valueOf(year);
    }

    public void setValues(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        date = String.valueOf(month) + String.valueOf(day) + String.valueOf(year);
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
