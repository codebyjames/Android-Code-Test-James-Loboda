package com.loboda.james.androidcodetestjamesloboda.helper;

import android.util.Log;

import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.model.Birthday;
import com.loboda.james.androidcodetestjamesloboda.model.Email;
import com.loboda.james.androidcodetestjamesloboda.model.Phone;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactDetailViews;

import java.util.ArrayList;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class HelperContactDetails {

    public static void prepareContactDetails() {

        // update adapters if changes were made in edit layout
        updateAllAdapters();

        // set addresses
        Lists.addressList = new ArrayList<>();
        for (Address item : TrackContact.currentContact.getAddresses()) {
            Lists.addressList.add(item);
        }

        // set phones
        Lists.phoneList = new ArrayList<>();
        for (Phone item : TrackContact.currentContact.getPhones()) {
            Lists.phoneList.add(item);
        }

        // emails
        Lists.emailList = new ArrayList<>();
        for (Email item : TrackContact.currentContact.getEmails()) {
            Lists.emailList.add(item);
        }

        setNames();
        setBirthday();

    }

    public static void setNames() {

        // first name
        String firstName = "";
        try {
            firstName = TrackContact.currentContact.getFirstName();
        } catch (Exception ex) {
            ex.printStackTrace();
            firstName = "";
        }

        // last name
        String lastName = "";
        try {
            lastName = TrackContact.currentContact.getLastName();
        } catch (Exception ex) {
            lastName = "";
        }

        // set views
        ContactDetailViews.textFirstName.setText(firstName);
        ContactDetailViews.textLastName.setText(lastName);

    }

    public static void setBirthday() {

        String date = "";
        // set birthday
        try {
            date = TrackContact.currentContact.getBirthDate().getDate();
        } catch (Exception ex) {
            ex.printStackTrace();
            date = "";
        }

        if (Util.isStringEmpty(date)) {

            ContactDetailViews.textBirthdayMonth.setText("");
            ContactDetailViews.textBirthdayDay.setText("");
            ContactDetailViews.textBirthdayYear.setText("");

        } else {

            Birthday birthday = TrackContact.currentContact.getBirthDate();

            int month = birthday.getMonth();
            int day = birthday.getDay();
            int year = birthday.getYear();
            ContactDetailViews.textBirthdayMonth.setText("" + month);
            ContactDetailViews.textBirthdayDay.setText("" + day);
            ContactDetailViews.textBirthdayYear.setText("" + year);

        }

    }

    public static void updateAllAdapters(){

        ContactDetailViews.addressesAdapter.notifyDataSetChanged();
        ContactDetailViews.phonesAdapter.notifyDataSetChanged();
        ContactDetailViews.emailsAdapter.notifyDataSetChanged();

    }

}
