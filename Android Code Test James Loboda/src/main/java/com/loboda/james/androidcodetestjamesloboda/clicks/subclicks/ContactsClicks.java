package com.loboda.james.androidcodetestjamesloboda.clicks.subclicks;

import android.view.View;

import com.loboda.james.androidcodetestjamesloboda.helper.HelperAddContact;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperContacts;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactsViews;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class ContactsClicks {

    public static void setClicks(){

        onClickInputSearchNames();
        onClickCancelSearch();
        onClickAddContact();

    }

    private static void onClickInputSearchNames(){

        ContactsViews.inputSearchContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HelperContacts.processClickInputSearchNames();

            }
        });

    }

    private static void onClickCancelSearch(){

        ContactsViews.buttonCancelSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HelperContacts.cancelSearch();

            }
        });

    }

    private static void onClickAddContact(){

        ContactsViews.buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // prepare add layout
                HelperAddContact.prepareEditContact();

                // show layout
                Views.showLayoutAddContact();

            }
        });

    }

}
