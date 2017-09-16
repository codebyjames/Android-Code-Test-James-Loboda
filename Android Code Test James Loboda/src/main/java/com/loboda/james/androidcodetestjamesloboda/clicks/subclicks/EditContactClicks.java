package com.loboda.james.androidcodetestjamesloboda.clicks.subclicks;

import android.os.Handler;
import android.view.View;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperEditContact;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryEditContact;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.EditContactViews;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class EditContactClicks {

    public static void setClicks(){

        onClickCancel();
        onClickDone();
        onClickAddPhone();
        onClickAddEmail();
        onClickAddAddress();

    }

    private static void onClickCancel(){

        EditContactViews.textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // go back to contact detail layout
                Views.showLayoutContactDetails();

            }
        });

    }

    private static void onClickDone(){

        EditContactViews.textDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        // try to save contact
                        TemporaryEditContact.updateTempContact();

                    }
                };

                handler.post(runnable);

            }
        });

    }

    private static void onClickAddPhone(){

        EditContactViews.buttonAddPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TemporaryEditContact.addPhone();

                // scroll to bottom
                HelperEditContact.scrollToBottomPhoneList();

            }
        });

    }

    private static void onClickAddEmail(){

        EditContactViews.buttonAddEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TemporaryEditContact.addEmail();

                // scroll to bottom
                HelperEditContact.scrollToBottomEmailList();

            }
        });

    }

    private static void onClickAddAddress(){

        EditContactViews.buttonAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TemporaryEditContact.addAddress();

                // scroll to bottom
                HelperEditContact.scrollToBottomAddressList();

            }
        });

    }

}
