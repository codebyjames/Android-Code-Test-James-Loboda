package com.loboda.james.androidcodetestjamesloboda.helper;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.model.Contact;
import com.loboda.james.androidcodetestjamesloboda.model.Phone;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactsViews;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class HelperContacts {

    private static Activity context = MainActivity.mainContext;
    public static boolean isCancelSearchButtonVisible = false;
    public static boolean isTopLayoutVisible = true;

    public static void cancelSearch(){

        // hide keyboard
        Util.hideKeyboard(ContactsViews.inputSearchContacts);

        // clear search
        ContactsViews.inputSearchContacts.setText("");

        // check top layout visibility
        if (isTopLayoutVisible) {
            // do nothing
        } else {

            // show top layout
            ContactsViews.topContactsLayout.setVisibility(View.VISIBLE);
            isTopLayoutVisible = true;

        }

        // hide cancel button
        ContactsViews.buttonCancelSearch.setVisibility(View.GONE);
        isCancelSearchButtonVisible = false;

        // status bar color
        Util.changeColorsStatusBar(R.color.colorOrange);

    }

    public static void processClickInputSearchNames(){

        // check top layout visibility
        if (isTopLayoutVisible) {

            // hide top layout
            ContactsViews.topContactsLayout.setVisibility(View.GONE);
            isTopLayoutVisible = false;

        } else {
            isTopLayoutVisible = true;
        }

        // check cancel search button visibility
        if (isCancelSearchButtonVisible) {
            // do nothing
        } else {

            // show cancel button
            ContactsViews.buttonCancelSearch.setVisibility(View.VISIBLE);
            isCancelSearchButtonVisible = true;
        }

        // status bar color
        Util.changeColorsStatusBar(R.color.colorLightGray);

    }

    public static boolean isFirstNameEmpty(int position){

        boolean isEmpty = false;

        if (Util.isStringEmpty(Lists.filteredContactList.get(position).getFirstName())) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }

        return isEmpty;

    }

    public static boolean isLastNameEmpty(int position){

        boolean isEmpty = false;

        if (Util.isStringEmpty(Lists.filteredContactList.get(position).getLastName())) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }

        return isEmpty;

    }

    public static String getFirstName(int position) {
        return Lists.filteredContactList.get(position).getFirstName();
    }

    public static String getLastName(int position) {
        return Lists.filteredContactList.get(position).getLastName();
    }

    public static void setSearchTextListener(){

        ContactsViews.inputSearchContacts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                filterContacts(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public static void filterContacts(CharSequence charSequence){

        String pattern = charSequence.toString().toLowerCase().trim();

        Lists.filteredContactList.clear();
        for (Contact item : Lists.contactList) {

            if (item.getFirstName().toLowerCase().startsWith(pattern)
                    || item.getLastName().toLowerCase().startsWith(pattern)) {

                Lists.filteredContactList.add(item);

            } else if (Util.isStringEmpty(pattern)){

                Lists.filteredContactList.addAll(Lists.contactList);

            }

        }

        // sort list
        Collections.sort(Lists.filteredContactList);

        // update adapter
        ContactsViews.contactsAdapter.notifyDataSetChanged();

    }

}
