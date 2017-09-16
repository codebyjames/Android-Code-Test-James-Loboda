package com.loboda.james.androidcodetestjamesloboda;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperContacts;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperCountries;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.Views;

public class MainActivity extends AppCompatActivity {

    public static Activity mainContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContext = this;
        Util.setToast();
        Database.setRealmDB(this);
        setActivity();

    }

    private void setActivity() {

        // set app full screen
        Util.setAppFullScreenStatusBar();

        // set views
        Views.setViews();

        // set lists
        Lists.setAllLists();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (HelperContacts.isCancelSearchButtonVisible) {
            HelperContacts.cancelSearch();
        } else {
            Util.setAppFullScreenStatusBar();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Database.realmDB.close();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            if (hasFocus) {

                if (HelperContacts.isCancelSearchButtonVisible) {
                    HelperContacts.cancelSearch();
                } else {
                    Util.setAppFullScreenStatusBar();
                }

            }
        }

    }

    @Override
    public void onBackPressed() {

        if (Views.currentView == Views.LAYOUT_CONTACTS) {

            if (HelperContacts.isCancelSearchButtonVisible) {
                HelperContacts.cancelSearch();
            } else {
                super.onBackPressed();
            }

        } else if (Views.currentView == Views.LAYOUT_CONTACT_DETAILS) {

            if (HelperContacts.isCancelSearchButtonVisible) {
                HelperContacts.cancelSearch();
            }

            Views.showLayoutContacts();

        } else if (Views.currentView == Views.LAYOUT_ADD_CONTACT) {

            try {

                // delete temporary contact (contact is saved as soon as user presses add contact)
                Database.deleteContactFromDB(TemporaryAddContact.tempContact.getId());

            } catch (Exception ex) {

            }

            Views.showLayoutContacts();

        } else if (Views.currentView == Views.LAYOUT_EDIT_CONTACT) {

            Views.showLayoutContactDetails();

        } else if (Views.currentView == Views.LAYOUT_PHONE_LABELS) {

            HelperPhoneLabels.goToPreviousLayout();

        } else if (Views.currentView == Views.LAYOUT_COUNTRIES) {

            HelperCountries.goToPreviousLayout();

        }
    }
}
