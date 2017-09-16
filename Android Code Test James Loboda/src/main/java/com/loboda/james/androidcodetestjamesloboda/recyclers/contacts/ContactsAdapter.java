package com.loboda.james.androidcodetestjamesloboda.recyclers.contacts;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.animation.AnimationObject;
import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperContacts;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactsViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsRowHolder>{

    public ContactsAdapter(){

    }

    @Override
    public ContactsRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactsRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactsRowHolder holder, int position) {

        String firstName = "";
        String lastName = "";
        String fullName = "";

        if (HelperContacts.isFirstNameEmpty(position)) {
            firstName = "";
        } else {
            firstName = HelperContacts.getFirstName(position);
        }

        if (HelperContacts.isLastNameEmpty(position)) {
            lastName = "";
        } else {
            HelperContacts.getLastName(position);
        }

        fullName = firstName + " " + lastName;
        holder.textName.setText(fullName);

        // click item to go to contact detail
        onClickItem(holder.root, position);

        // delete (200ms delay)
        onClickDelete(holder.buttonDelete, position, 200);

    }

    @Override
    public int getItemCount() {
        return Lists.filteredContactList.size();
    }

    private void onClickDelete(final ImageView buttonDelete, final int position, final int delay) {

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AnimationObject.grow(buttonDelete, 200, 1.1f);

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        long id = Lists.filteredContactList.get(position).getId();
                        Database.deleteContactFromDB(id);

                        // filter list again after delete
                        String pattern = ContactsViews.inputSearchContacts.getText().toString();
                        HelperContacts.filterContacts(pattern);

                    }
                };

                handler.postDelayed(runnable, delay);

            }
        });

    }

    private void onClickItem(final View view, final int position) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        TrackContact.currentContact = Lists.filteredContactList.get(position);
                        long id = TrackContact.currentContact.getId();
                        TrackContact.currentEditId = id;

                        // go to contact detail screen
                        Views.showLayoutContactDetails();

                    }
                };

                handler.post(runnable);

            }
        });

    }

}
