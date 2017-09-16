package com.loboda.james.androidcodetestjamesloboda.helper;

import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryEditContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackPhoneLabel;
import com.loboda.james.androidcodetestjamesloboda.views.Views;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class HelperPhoneLabels {

    public static String TYPE_MOBILE = "mobile";
    public static String TYPE_HOME = "home";
    public static String TYPE_WORK = "work";
    public static String TYPE_HOME_FAX = "home fax";
    public static String TYPE_WORK_FAX = "work fax";
    public static String TYPE_OTHER = "other";

    public static void goToPreviousLayout(){

        // go back to previous screen
        if (TrackPhoneLabel.previousLayout == Views.LAYOUT_EDIT_CONTACT) {
            Views.showLayoutEditContact();
        } else if (TrackPhoneLabel.previousLayout == Views.LAYOUT_ADD_CONTACT) {
            Views.showLayoutAddContact();
        }

    }

    public static void updatePhoneLabel(){

        String label = TrackPhoneLabel.currentPhoneLabel;
        int phoneIndex = TrackPhoneLabel.currentPhoneIndex;

        // data
        long number = 0;
        try {
            number = TrackPhoneLabel.currentPhone.getNumber();
        } catch (Exception ex) {
            ex.printStackTrace();
            number = 0;
        }

        // update
        if (TrackPhoneLabel.previousLayout == Views.LAYOUT_EDIT_CONTACT) {

            TemporaryEditContact.updateItemPhone(phoneIndex, number, label);
            TemporaryEditContact.updateAdapterPhones();

        } else if (TrackPhoneLabel.previousLayout == Views.LAYOUT_ADD_CONTACT) {

            TemporaryAddContact.updateItemPhone(phoneIndex, number, label);
            TemporaryAddContact.updateAdapterPhones();

        }

    }

}
