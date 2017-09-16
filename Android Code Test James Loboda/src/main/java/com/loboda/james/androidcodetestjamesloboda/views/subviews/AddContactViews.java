package com.loboda.james.androidcodetestjamesloboda.views.subviews;

import android.app.Activity;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_add.addresses.ContactAddAddressesAdapter;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_add.emails.ContactAddEmailsAdapter;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_add.phones.ContactAddPhonesAdapter;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class AddContactViews {

    private static Activity context = MainActivity.mainContext;

    // top
    public static TextView textCancel, textDone;

    // center
    public static EditText inputFirstName, inputLastName;
    public static EditText inputBirthdayMonth, inputBirthdayDay, inputBirthdayYear;
    public static ImageView buttonAddPhone, buttonAddAddress, buttonAddEmail;

    // bottom
    public static NestedScrollView scroll;
    public static RecyclerView recyclerListAddPhones, recyclerListAddAddresses, recyclerListAddEmails;
    public static ContactAddPhonesAdapter addPhonesAdapter;
    public static ContactAddAddressesAdapter addAddressesAdapter;
    public static ContactAddEmailsAdapter addEmailsAdapter;

    public static void setViews() {

        setTop();
        setCenter();
        setBottom();
    }

    private static void setTop(){

        textCancel = context.findViewById(R.id.text_add_cancel);
        textDone = context.findViewById(R.id.text_add_done);

    }

    private static void setCenter(){

        inputFirstName = context.findViewById(R.id.input_add_first_name);
        inputLastName = context.findViewById(R.id.input_add_last_name);
        inputBirthdayMonth = context.findViewById(R.id.input_add_birthday_month);
        inputBirthdayDay = context.findViewById(R.id.input_add_birthday_day);
        inputBirthdayYear = context.findViewById(R.id.input_add_birthday_year);
        buttonAddPhone = context.findViewById(R.id.button_add_layout_add_phone);
        buttonAddAddress = context.findViewById(R.id.button_add_layout_add_address);
        buttonAddEmail = context.findViewById(R.id.button_add_layout_add_email);

    }

    private static void setBottom(){

        scroll = context.findViewById(R.id.scroll_add_layout);
        recyclerListAddPhones = context.findViewById(R.id.recycler_list_add_layout_phones);
        recyclerListAddAddresses = context.findViewById(R.id.recycler_list_add_layout_addresses);
        recyclerListAddEmails = context.findViewById(R.id.recycler_list_add_layout_emails);

        setRecyclerListAddPhones();
        setRecyclerListAddAddresses();
        setRecyclerListAddEmails();

    }

    private static void setRecyclerListAddPhones(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        addPhonesAdapter = new ContactAddPhonesAdapter();
        recyclerListAddPhones.setLayoutManager(linearLayoutManager);
        recyclerListAddPhones.setAdapter(addPhonesAdapter);
        recyclerListAddPhones.setNestedScrollingEnabled(false);

    }

    private static void setRecyclerListAddAddresses(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        addAddressesAdapter = new ContactAddAddressesAdapter();
        recyclerListAddAddresses.setLayoutManager(linearLayoutManager);
        recyclerListAddAddresses.setAdapter(addAddressesAdapter);
        recyclerListAddAddresses.setNestedScrollingEnabled(false);

    }

    private static void setRecyclerListAddEmails(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        addEmailsAdapter = new ContactAddEmailsAdapter();
        recyclerListAddEmails.setLayoutManager(linearLayoutManager);
        recyclerListAddEmails.setAdapter(addEmailsAdapter);
        recyclerListAddEmails.setNestedScrollingEnabled(false);

    }

}
