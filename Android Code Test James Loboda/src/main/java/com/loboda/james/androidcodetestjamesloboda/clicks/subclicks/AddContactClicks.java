package com.loboda.james.androidcodetestjamesloboda.clicks.subclicks;

import android.os.Handler;
import android.view.View;

import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperAddContact;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.AddContactViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class AddContactClicks {

    public static void setClicks(){

        onClickCancel();
        onClickDone();
        onClickAddPhone();
        onClickAddEmail();
        onClickAddAddress();

    }

    private static void onClickCancel(){

        AddContactViews.textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // delete temporary contact
                Database.deleteContactFromDB(TemporaryAddContact.tempContact.getId());

                // go back to contact layout
                Views.showLayoutContacts();

            }
        });

    }

    private static void onClickDone(){

        AddContactViews.textDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        // try to save contact
                        TemporaryAddContact.saveTempContact();

                    }
                };

                handler.post(runnable);

            }
        });

    }

    private static void onClickAddPhone(){

        AddContactViews.buttonAddPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TemporaryAddContact.addPhone();

                // scroll to bottom
                HelperAddContact.scrollToBottomPhoneList();

            }
        });

    }

    private static void onClickAddEmail(){

        AddContactViews.buttonAddEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TemporaryAddContact.addEmail();

                // scroll to bottom
                HelperAddContact.scrollToBottomEmailList();

            }
        });

    }

    private static void onClickAddAddress(){

        AddContactViews.buttonAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TemporaryAddContact.addAddress();

                // scroll to bottom
                HelperAddContact.scrollToBottomAddressList();

            }
        });

    }
}
