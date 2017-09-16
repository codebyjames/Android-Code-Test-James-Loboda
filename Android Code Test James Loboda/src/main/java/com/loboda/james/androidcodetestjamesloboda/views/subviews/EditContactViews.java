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
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_edit.addresses.ContactEditAddressesAdapter;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_edit.emails.ContactEditEmailsAdapter;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_edit.phones.ContactEditPhonesAdapter;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class EditContactViews {

    private static Activity context = MainActivity.mainContext;

    // top
    public static TextView textCancel, textDone;

    // center
    public static EditText inputFirstName, inputLastName;
    public static EditText inputBirthdayMonth, inputBirthdayDay, inputBirthdayYear;
    public static ImageView buttonAddPhone, buttonAddAddress, buttonAddEmail;

    // bottom
    public static NestedScrollView scroll;
    public static RecyclerView recyclerListEditPhones, recyclerListEditAddresses, recyclerListEditEmails;
    public static ContactEditPhonesAdapter editPhonesAdapter;
    public static ContactEditAddressesAdapter editAddressesAdapter;
    public static ContactEditEmailsAdapter editEmailsAdapter;

    public static void setViews() {

        setTop();
        setCenter();
        setBottom();
    }

    private static void setTop(){

        textCancel = context.findViewById(R.id.text_edit_cancel);
        textDone = context.findViewById(R.id.text_edit_done);

    }

    private static void setCenter(){

        inputFirstName = context.findViewById(R.id.input_edit_first_name);
        inputLastName = context.findViewById(R.id.input_edit_last_name);
        inputBirthdayMonth = context.findViewById(R.id.input_edit_birthday_month);
        inputBirthdayDay = context.findViewById(R.id.input_edit_birthday_day);
        inputBirthdayYear = context.findViewById(R.id.input_edit_birthday_year);
        buttonAddPhone = context.findViewById(R.id.button_edit_layout_add_phone);
        buttonAddAddress = context.findViewById(R.id.button_edit_layout_add_address);
        buttonAddEmail = context.findViewById(R.id.button_edit_layout_add_email);

    }

    private static void setBottom(){

        scroll = context.findViewById(R.id.scroll_edit_layout);
        recyclerListEditPhones = context.findViewById(R.id.recycler_list_edit_layout_phones);
        recyclerListEditAddresses = context.findViewById(R.id.recycler_list_edit_layout_addresses);
        recyclerListEditEmails = context.findViewById(R.id.recycler_list_edit_layout_emails);

        setRecyclerListAddPhones();
        setRecyclerListAddAddresses();
        setRecyclerListAddEmails();

    }

    private static void setRecyclerListAddPhones(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        editPhonesAdapter = new ContactEditPhonesAdapter();
        recyclerListEditPhones.setLayoutManager(linearLayoutManager);
        recyclerListEditPhones.setAdapter(editPhonesAdapter);
        recyclerListEditPhones.setNestedScrollingEnabled(false);

    }

    private static void setRecyclerListAddAddresses(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        editAddressesAdapter = new ContactEditAddressesAdapter();
        recyclerListEditAddresses.setLayoutManager(linearLayoutManager);
        recyclerListEditAddresses.setAdapter(editAddressesAdapter);
        recyclerListEditAddresses.setNestedScrollingEnabled(false);

    }

    private static void setRecyclerListAddEmails(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setAutoMeasureEnabled(true);
        editEmailsAdapter = new ContactEditEmailsAdapter();
        recyclerListEditEmails.setLayoutManager(linearLayoutManager);
        recyclerListEditEmails.setAdapter(editEmailsAdapter);
        recyclerListEditEmails.setNestedScrollingEnabled(false);

    }

}
