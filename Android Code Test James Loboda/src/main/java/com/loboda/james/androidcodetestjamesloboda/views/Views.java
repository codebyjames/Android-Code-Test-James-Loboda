package com.loboda.james.androidcodetestjamesloboda.views;

import android.app.Activity;
import android.widget.LinearLayout;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.clicks.Clicks;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperContactDetails;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperEditContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackPhoneLabel;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.AddContactViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactDetailViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactsViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.CountriesViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.EditContactViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.PhoneLabelsViews;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class Views {

    private static Activity context = MainActivity.mainContext;
    public static final int LAYOUT_CONTACTS = 1;
    public static final int LAYOUT_CONTACT_DETAILS = 2;
    public static final int LAYOUT_EDIT_CONTACT = 3;
    public static final int LAYOUT_COUNTRIES = 4;
    public static final int LAYOUT_PHONE_LABELS = 5;
    public static final int LAYOUT_ADD_CONTACT = 6;
    public static int currentView = LAYOUT_CONTACTS;

    // views
    private static LinearLayout rootContacts, rootContactDetails,
            rootEditContact, rootCountries, rootPhoneLabels, rootAddContact;

    // region SET VIEWS
    public static void setViews(){

        // set root views
        rootContacts = context.findViewById(R.id.root_contacts);
        rootContactDetails = context.findViewById(R.id.root_contact_details);
        rootEditContact = context.findViewById(R.id.root_edit_contact);
        rootCountries = context.findViewById(R.id.root_countries);
        rootPhoneLabels = context.findViewById(R.id.root_phone_labels);
        rootAddContact = context.findViewById(R.id.root_add_contact);

        // set views
        setLayoutContacts();
        setLayoutContactDetails();
        setLayoutEditContact();
        setLayoutCountries();
        setLayoutPhoneLabels();
        setLayoutAddContact();

    }

    public static void setLayoutContacts(){

        ContactsViews.setViews();
        Clicks.setContactsClicks();

    }

    public static void setLayoutContactDetails(){

        ContactDetailViews.setViews();
        Clicks.setContactDetailsClicks();

    }

    public static void setLayoutEditContact(){

        EditContactViews.setViews();
        Clicks.setEditContactClicks();

    }

    public static void setLayoutCountries(){

        CountriesViews.setViews();
        Clicks.setCountriesClicks();

    }

    public static void setLayoutPhoneLabels(){

        PhoneLabelsViews.setViews();
        Clicks.setPhoneLabelsClicks();

    }

    public static void setLayoutAddContact(){

        AddContactViews.setViews();
        Clicks.setAddContactClicks();

    }

    // endregion

    // region SHOW LAYOUT

    public static void showLayoutContacts(){

        // hide keyboard
        Util.hideKeyboardAddContact();

        // show layout
        showLayout(LAYOUT_CONTACTS);
    }

    public static void showLayoutContactDetails(){

        // prepare data for current contact
        HelperContactDetails.prepareContactDetails();

        // hide keyboard
        Util.hideKeyboardEditContact();

        // show layout
        showLayout(LAYOUT_CONTACT_DETAILS);
    }

    public static void showLayoutEditContact(){

        // scroll to top
        HelperEditContact.scrollToTopNestedView();

        // show layout
        showLayout(LAYOUT_EDIT_CONTACT);
    }

    public static void showLayoutCountries(){
        showLayout(LAYOUT_COUNTRIES);
    }

    public static void showLayoutPhoneLabels(){
        showLayout(LAYOUT_PHONE_LABELS);
    }

    public static void showLayoutAddContact(){
        showLayout(LAYOUT_ADD_CONTACT);
    }

    // endregion

    /**
     * Switch layouts: go from one layout to another
     * @param newLayout
     */
    public static void showLayout(int newLayout) {

        if (newLayout == currentView) {
            // do nothing
        } else {

            currentView = newLayout;
            switch (currentView) {
                case LAYOUT_CONTACTS:
                    Util.hideView(rootContactDetails);
                    Util.hideView(rootEditContact);
                    Util.hideView(rootCountries);
                    Util.hideView(rootPhoneLabels);
                    Util.hideView(rootAddContact);
                    Util.showView(rootContacts);
                    break;
                case LAYOUT_CONTACT_DETAILS:
                    Util.hideView(rootContacts);
                    Util.hideView(rootEditContact);
                    Util.hideView(rootCountries);
                    Util.hideView(rootPhoneLabels);
                    Util.hideView(rootAddContact);
                    Util.showView(rootContactDetails);
                    break;
                case LAYOUT_EDIT_CONTACT:
                    Util.hideView(rootContacts);
                    Util.hideView(rootContactDetails);
                    Util.hideView(rootCountries);
                    Util.hideView(rootPhoneLabels);
                    Util.hideView(rootAddContact);
                    Util.showView(rootEditContact);
                    break;
                case LAYOUT_COUNTRIES:
                    Util.hideView(rootContacts);
                    Util.hideView(rootContactDetails);
                    Util.hideView(rootEditContact);
                    Util.hideView(rootPhoneLabels);
                    Util.hideView(rootAddContact);
                    Util.showView(rootCountries);
                    break;
                case LAYOUT_PHONE_LABELS:
                    Util.hideView(rootContacts);
                    Util.hideView(rootContactDetails);
                    Util.hideView(rootEditContact);
                    Util.hideView(rootCountries);
                    Util.hideView(rootAddContact);
                    Util.showView(rootPhoneLabels);
                    break;
                case LAYOUT_ADD_CONTACT:
                    Util.hideView(rootContacts);
                    Util.hideView(rootContactDetails);
                    Util.hideView(rootEditContact);
                    Util.hideView(rootCountries);
                    Util.hideView(rootPhoneLabels);
                    Util.showView(rootAddContact);
                    break;

            }

            // set app to full screen
            Util.setAppFullScreenStatusBar();

            // status bar color
            Util.changeColorsStatusBar(R.color.colorOrange);

        }

    }

}
