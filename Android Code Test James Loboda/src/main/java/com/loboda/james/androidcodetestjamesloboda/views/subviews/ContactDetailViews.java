package com.loboda.james.androidcodetestjamesloboda.views.subviews;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.addresses.ContactDetailsAddressesAdapter;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.emails.ContactDetailsEmailsAdapter;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.phones.ContactDetailsPhonesAdapter;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class ContactDetailViews {

    private static Activity context = MainActivity.mainContext;

    // top
    public static TextView textBack, textEdit;

    // center
    public static ImageView buttonCall, buttonMessage;
    public static TextView textFirstName, textLastName;
    public static TextView textBirthdayMonth, textBirthdayDay, textBirthdayYear;

    // bottom
    public static RecyclerView recyclerListPhones, recyclerListAddresses, recyclerListEmails;
    public static ContactDetailsAddressesAdapter addressesAdapter;
    public static ContactDetailsPhonesAdapter phonesAdapter;
    public static ContactDetailsEmailsAdapter emailsAdapter;


    public static void setViews(){

        setTop();
        setCenter();
        setBottom();

    }

    private static void setCenter(){

        buttonCall = context.findViewById(R.id.button_call);
        buttonMessage = context.findViewById(R.id.button_message);
        textFirstName = context.findViewById(R.id.text_first_name);
        textLastName = context.findViewById(R.id.text_last_name);
        textBirthdayMonth = context.findViewById(R.id.text_birthday_month);
        textBirthdayDay = context.findViewById(R.id.text_birthday_day);
        textBirthdayYear = context.findViewById(R.id.text_birthday_year);

    }

    private static void setTop(){

        textBack = context.findViewById(R.id.text_contact_detail_back);
        textEdit = context.findViewById(R.id.text_contact_detail_edit);

    }

    private static void setBottom(){

        recyclerListPhones = context.findViewById(R.id.recycler_list_phones);
        recyclerListAddresses = context.findViewById(R.id.recycler_list_addresses);
        recyclerListEmails = context.findViewById(R.id.recycler_list_emails);

        setRecyclerListPhones();
        setRecyclerListAddresses();
        setRecyclerListEmails();

    }

    private static void setRecyclerListPhones(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        phonesAdapter = new ContactDetailsPhonesAdapter();
        recyclerListPhones.setLayoutManager(linearLayoutManager);
        recyclerListPhones.setAdapter(phonesAdapter);
        recyclerListPhones.setNestedScrollingEnabled(false);

    }

    private static void setRecyclerListAddresses(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        addressesAdapter = new ContactDetailsAddressesAdapter();
        recyclerListAddresses.setLayoutManager(linearLayoutManager);
        recyclerListAddresses.setAdapter(addressesAdapter);
        recyclerListAddresses.setNestedScrollingEnabled(false);

    }

    private static void setRecyclerListEmails(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        emailsAdapter = new ContactDetailsEmailsAdapter();
        recyclerListEmails.setLayoutManager(linearLayoutManager);
        recyclerListEmails.setAdapter(emailsAdapter);
        recyclerListEmails.setNestedScrollingEnabled(false);

    }

}
