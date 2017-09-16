package com.loboda.james.androidcodetestjamesloboda.clicks.subclicks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperEditContact;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactDetailViews;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class ContactDetailsClicks {

    private static Activity context = MainActivity.mainContext;

    public static void setClicks(){

        onClickBack();
        onClickEdit();
        onClickCall();
        onClickMessage();

    }

    private static void onClickBack(){

        ContactDetailViews.textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Views.showLayoutContacts();

            }
        });

    }

    private static void onClickEdit(){

        ContactDetailViews.textEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // prepare data for current contact
                HelperEditContact.prepareEditContact();
                Views.showLayoutEditContact();

            }
        });

    }

    private static void onClickCall(){

        ContactDetailViews.buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Lists.phoneList.isEmpty() || Lists.phoneList != null || Lists.phoneList.size() > 0) {

                    long phoneNumber = Lists.phoneList.get(0).getNumber();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    context.startActivity(intent);

                } else {
                    Util.showToastMessage("No Phone Number");
                }

            }
        });

    }

    private static void onClickMessage(){

        ContactDetailViews.buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Lists.phoneList.isEmpty() || Lists.phoneList != null || Lists.phoneList.size() > 0) {

                    long phoneNumber = Lists.phoneList.get(0).getNumber();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("sms:" + phoneNumber));
                    context.startActivity(intent);

                } else {
                    Util.showToastMessage("No Phone Number");
                }

            }
        });


    }

}
