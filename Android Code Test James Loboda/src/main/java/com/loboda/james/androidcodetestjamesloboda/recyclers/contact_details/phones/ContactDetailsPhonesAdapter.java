package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.phones;

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
import com.loboda.james.androidcodetestjamesloboda.recyclers.contacts.ContactsRowHolder;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactDetailsPhonesAdapter extends RecyclerView.Adapter<ContactDetailsPhonesRowHolder>{

    public ContactDetailsPhonesAdapter(){

    }

    @Override
    public ContactDetailsPhonesRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone, parent, false);
        return new ContactDetailsPhonesRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactDetailsPhonesRowHolder holder, int position) {

        String type = Lists.phoneList.get(position).getType();
        long number = Lists.phoneList.get(position).getNumber();
        String styleNumber = Util.convertPhoneNumberToString(number);

        // set views
        holder.textPhoneType.setText(type);
        holder.textPhoneNumber.setText(styleNumber);

        // delete (200ms delay)
        onClickDelete(holder.buttonDelete, position, 200);

    }

    @Override
    public int getItemCount() {
        return Lists.phoneList.size();
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

                        if (Lists.phoneList.size() > 1) {

                            Database.deletePhoneFromDB(TrackContact.currentEditId, position);
                            ContactDetailsPhonesAdapter.this.notifyDataSetChanged();

                        } else {
                            Util.showToastMessage("Must have at least 1 phone number.");
                        }

                    }
                };

                handler.postDelayed(runnable, delay);

            }
        });

    }

}
