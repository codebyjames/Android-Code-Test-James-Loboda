package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_add.addresses;

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
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackCountry;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.CountriesViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactAddAddressesAdapter extends RecyclerView.Adapter<ContactAddAddressesRowHolder>{

    public ContactAddAddressesAdapter(){

    }

    @Override
    public ContactAddAddressesRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address_edit, parent, false);
        return new ContactAddAddressesRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactAddAddressesRowHolder holder, int position) {

        String street = TemporaryAddContact.addAddressList.get(position).getStreet();
        String street2 = TemporaryAddContact.addAddressList.get(position).getStreet2();
        String city = TemporaryAddContact.addAddressList.get(position).getCity();
        String state = TemporaryAddContact.addAddressList.get(position).getState();
        long zip = getZip(position);
        String country = TemporaryAddContact.addAddressList.get(position).getCountry();

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
        return TemporaryAddContact.addAddressList.size();
    }

    /**
     * Try/Catch to get zip value
     * @param position
     * @return
     */
    private static long getZip(int position){

        long zip = 0;

        try {
            zip = TemporaryAddContact.addAddressList.get(position).getZipcode();
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

                        TemporaryAddContact.deleteAddress(position);

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

                Address address = TemporaryAddContact.addAddressList.get(position);

                String street = editable.toString();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryAddContact.updateItemAddress(position, street, street2, city,
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

                Address address = TemporaryAddContact.addAddressList.get(position);

                String street = address.getStreet();
                String street2 = editable.toString();
                String city = address.getCity();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryAddContact.updateItemAddress(position, street, street2, city,
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

                Address address = TemporaryAddContact.addAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = editable.toString();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryAddContact.updateItemAddress(position, street, street2, city,
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

                Address address = TemporaryAddContact.addAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = editable.toString();
                long zip = address.getZipcode();
                String country = address.getCountry();

                TemporaryAddContact.updateItemAddress(position, street, street2, city,
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

                Address address = TemporaryAddContact.addAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = address.getState();
                String zipText = editable.toString();
                long zip = getZip(zipText);
                String country = address.getCountry();

                TemporaryAddContact.updateItemAddress(position, street, street2, city,
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

                Address address = TemporaryAddContact.addAddressList.get(position);

                String street = address.getStreet();
                String street2 = address.getStreet2();
                String city = address.getCity();
                String state = address.getState();
                long zip = address.getZipcode();
                String country = editable.toString();

                TemporaryAddContact.updateItemAddress(position, street, street2, city,
                        state,zip, country);

            }
        });

    }

    private void onClickCountry(View view, final int position) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set data
                TrackCountry.previousLayout = Views.LAYOUT_ADD_CONTACT;
                TrackCountry.currentAddress = TemporaryAddContact.addAddressList.get(position);
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
