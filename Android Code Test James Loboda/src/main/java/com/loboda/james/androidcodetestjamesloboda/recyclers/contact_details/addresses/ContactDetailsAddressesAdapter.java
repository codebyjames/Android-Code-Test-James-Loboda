package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.addresses;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
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

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactDetailsAddressesAdapter extends RecyclerView.Adapter<ContactDetailsAddressesRowHolder>{

    public ContactDetailsAddressesAdapter(){

    }

    @Override
    public ContactDetailsAddressesRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        return new ContactDetailsAddressesRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactDetailsAddressesRowHolder holder, int position) {

        String street = Lists.addressList.get(position).getStreet();
        String street2 = Lists.addressList.get(position).getStreet2();
        String city = Lists.addressList.get(position).getCity();
        String state = Lists.addressList.get(position).getState();
        long zip = Lists.addressList.get(position).getZipcode();
        String country = Lists.addressList.get(position).getCountry();

        // set views
        holder.textStreet.setText(street);
        holder.textStreet2.setText(street2);
        holder.textCity.setText(city);
        holder.textState.setText(state);

        if (zip == 0) {
            holder.textZip.setText("");
        } else {
            holder.textZip.setText("" + zip);
        }
        holder.textCountry.setText(country);

        // delete (200ms delay)
        onClickDelete(holder.buttonDelete, position, 200);

    }

    @Override
    public int getItemCount() {
        return Lists.addressList.size();
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

                        Database.deleteAddressFromDB(TrackContact.currentEditId, position);
                        ContactDetailsAddressesAdapter.this.notifyDataSetChanged();

                    }
                };

                handler.postDelayed(runnable, delay);

            }
        });

    }

}
