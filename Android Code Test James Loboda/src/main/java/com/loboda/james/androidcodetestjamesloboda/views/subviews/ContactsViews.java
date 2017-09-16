package com.loboda.james.androidcodetestjamesloboda.views.subviews;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperContacts;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contacts.ContactsAdapter;
import com.loboda.james.androidcodetestjamesloboda.util.Util;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class ContactsViews {

    private static Activity context = MainActivity.mainContext;

    // top
    public static LinearLayout topContactsLayout;
    public static ImageView buttonAddContact;

    // center
    public static ImageView buttonCancelSearch;
    public static EditText inputSearchContacts;

    // bottom
    public static RecyclerView recyclerListContacts;
    public static ContactsAdapter contactsAdapter;

    public static void setViews(){

        setTop();
        setCenter();
        setBottom();

    }

    private static void setTop(){

        topContactsLayout = context.findViewById(R.id.top_contacts_layout);
        buttonAddContact = context.findViewById(R.id.button_add_contact);

    }

    private static void setCenter(){

        buttonCancelSearch = context.findViewById(R.id.button_cancel_search);
        inputSearchContacts = context.findViewById(R.id.input_search_contacts);

        // search text listener
        HelperContacts.setSearchTextListener();

    }

    private static void setBottom(){

        recyclerListContacts = context.findViewById(R.id.recycler_list_contacts);
        setRecyclerListContacts();

    }

    private static void setRecyclerListContacts(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        contactsAdapter = new ContactsAdapter();
        recyclerListContacts.setLayoutManager(linearLayoutManager);
        recyclerListContacts.setAdapter(contactsAdapter);
    }

}
