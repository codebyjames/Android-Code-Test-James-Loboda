package com.loboda.james.androidcodetestjamesloboda.helper;

import android.view.View;

import com.loboda.james.androidcodetestjamesloboda.model.Birthday;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryEditContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.EditContactViews;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class HelperEditContact {

    public static void prepareEditContact() {

        // update adapters if changes were made in edit layout
        TemporaryEditContact.updateAllAdapters();

        // set temporary contact while editing
        TemporaryEditContact.setTempContact();

        // set current information for views
        setNames();
        setBirthday();

    }

    public static void setNames() {

        // first name
        String firstName = "";
        try {
            firstName = TemporaryEditContact.tempContact.getFirstName();
        } catch (Exception ex) {
            ex.printStackTrace();
            firstName = "";
        }

        // last name
        String lastName = "";
        try {
            lastName = TemporaryEditContact.tempContact.getLastName();
        } catch (Exception ex) {
            lastName = "";
        }

        // set views
        EditContactViews.inputFirstName.setText(firstName);
        EditContactViews.inputLastName.setText(lastName);

    }

    public static void setBirthday() {

        String date = "";
        // set birthday
        try {
            date = TemporaryEditContact.tempContact.getBirthDate().getDate();
        } catch (Exception ex) {
            ex.printStackTrace();
            date = "";
        }

        if (Util.isStringEmpty(date)) {

            EditContactViews.inputBirthdayMonth.setText("");
            EditContactViews.inputBirthdayDay.setText("");
            EditContactViews.inputBirthdayYear.setText("");

        } else {

            Birthday birthday = TrackContact.currentContact.getBirthDate();

            int month = birthday.getMonth();
            int day = birthday.getDay();
            int year = birthday.getYear();
            EditContactViews.inputBirthdayMonth.setText("" + month);
            EditContactViews.inputBirthdayDay.setText("" + day);
            EditContactViews.inputBirthdayYear.setText("" + year);

        }

    }

    // Scroll the Nested Scrollview

    public static void scrollToBottomPhoneList(){

        EditContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                int position = EditContactViews.recyclerListEditPhones.getBottom();
                EditContactViews.scroll.scrollTo(0, position);
            }
        });

    }

    public static void scrollToBottomEmailList(){

        EditContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                int position = EditContactViews.recyclerListEditEmails.getBottom();
                EditContactViews.scroll.scrollTo(0, position);
            }
        });

    }

    public static void scrollToBottomAddressList(){

        EditContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                int position = EditContactViews.recyclerListEditAddresses.getBottom();
                EditContactViews.scroll.scrollTo(0, position);
            }
        });

    }

    public static void scrollToBottomNestedView(){

        EditContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                EditContactViews.scroll.fullScroll(View.FOCUS_DOWN);
            }
        });

    }

    public static void scrollToTopNestedView(){

        EditContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                EditContactViews.scroll.scrollTo(0, 0);
            }
        });

    }

}
