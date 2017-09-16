package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_edit.addresses;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.animation.AnimationObject;
import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryEditContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackCountry;
import com.loboda.james.androidcodetestjamesloboda.util.TrackPhoneLabel;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.CountriesViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.PhoneLabelsViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactEditAddressesAdapter extends RecyclerView.Adapter<ContactEditAddressesRowHolder>{

    public ContactEditAddressesAdapter(){

    }

    @Override
    public ContactEditAddressesRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address_edit, parent, false);
        return new ContactEditAddressesRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactEditAddressesRowHolder holder, int position) {

        String street = TemporaryEditContact.editAddressList.get(position).getStreet();
        String street2 = TemporaryEditContact.editAddressList.get(position).getStreet2();
        String city = TemporaryEditContact.editAddressList.get(position).getCity();
        String state = TemporaryEditContact.editAddressList.get(position).getState();
        long zip = getZip(position);
        String country = TemporaryEditContact.editAddressList.get(position).getCountry();

        // set views
        holder.inputStreet.setText(street);
        holder.inputStreet2.setText(street2);
        holder.inputCity.setText(city);
        holder.inputState.setText(state);

        if (zip == 0) {
            holder.inputZipcode.setText("");
        } else {
            holder.inputZipcode.setText("" + zip);
        }
        holder.textCountry.setText(country);

        // detect text change
        detectTextChangeStreet(holder.inputStreet, position);
        detectTextChangeStreet2(holder.inputStreet2, position);
        detectTextChangeCity(holder.inputCity, position);
        detectTextChangeState(holder.inputState, position);
        detectTextChangeZip(holder.inputZipcode, position);
        detectTextChangeCountry(holder.textCountry, position);

        // change country
        onClickCountry(holder.textCountry, position);

        // delete (200ms delay)
        onClickDelete(holder.buttonDelete, position, 200);

    }

    @Override
    public int getItemCount() {
        return TemporaryEditContact.editAddressList.size();
    }

    /**
     * Try/Catch to get zip value
     * @param position
     * @return
     */
    private static long getZip(int position){

        long zip = 0;

        try {
            zip = TemporaryEditContact.editAddressList.get(position).getZipcode();
        } catch (Exception ex) {
            ex.printStackTrace();
            zip = 0;
        }

        return zip;


    }

    private static long getZip(String input){

        long zip = 0;

        try {
            zip = Long.parseLong(input);
        } catch (Exception ex) {
            ex.printStackTrace();
            zip = 0;
        }

        return zip;


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

                        TemporaryEditContact.deleteAddress(position);

                    }
                };

                handler.postDelayed(runnable, delay);

            }
        });

    }

    /**
     * Detect text change & change data in list that contains the original data
     */
    private void detectTextChangeStreet(EditText view, final int position) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Address address = TemporaryEditContact.editAddressList.get(position);

                String street = editable.toString();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryEditContact.updateItemAddress(position, street, street2, city,
                        state,zip, country);

            }
        });

    }

    private void detectTextChangeStreet2(EditText view, final int position) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Address address = TemporaryEditContact.editAddressList.get(position);

                String street = address.getStreet();
                String street2 = editable.toString();
                String city = address.getCity();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryEditContact.updateItemAddress(position, street, street2, city,
                        state,zip, country);

            }
        });

    }

    private void detectTextChangeCity(EditText view, final int position) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Address address = TemporaryEditContact.editAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = editable.toString();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryEditContact.updateItemAddress(position, street, street2, city,
                        state,zip, country);

            }
        });

    }

    private void detectTextChangeState(EditText view, final int position) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Address address = TemporaryEditContact.editAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = editable.toString();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryEditContact.updateItemAddress(position, street, street2, city,
                        state,zip, country);

            }
        });

    }

    private void detectTextChangeZip(EditText view, final int position) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Address address = TemporaryEditContact.editAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = address.getState();
                String zipText = editable.toString();
                long zip = getZip(zipText);
                String country = address.getCountry();

                TemporaryEditContact.updateItemAddress(position, street, street2, city,
                        state,zip, country);

            }
        });

    }

    private void detectTextChangeCountry(TextView view, final int position) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Address address = TemporaryEditContact.editAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = editable.toString();

                TemporaryEditContact.updateItemAddress(position, street, street2, city,
                        state,zip, country);

            }
        });

    }

    private void onClickCountry(View view, final int position) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set data
                TrackCountry.previousLayout = Views.LAYOUT_EDIT_CONTACT;
                TrackCountry.currentAddress = TemporaryEditContact.editAddressList.get(position);
                TrackCountry.currentCountry = TrackCountry.currentAddress.getCountry();
                TrackCountry.currentCountryIndex = position;

                // set current label
                String currentCountry = TrackCountry.currentCountry;
                CountriesViews.textCurrentLabel.setText(currentCountry);

                // go to phone label layout
                Views.showLayoutCountries();

            }
        });

    }

}
