package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_add.addresses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactAddAddressesRowHolder extends RecyclerView.ViewHolder{

    protected EditText inputStreet, inputStreet2, inputCity, inputState, inputZipcode;
    protected TextView textCountry;
    protected ImageView buttonDelete;

    public ContactAddAddressesRowHolder(View view) {
        super(view);

        inputStreet = view.findViewById(R.id.input_street);
        inputStreet2 = view.findViewById(R.id.input_street2);
        inputCity = view.findViewById(R.id.input_city);
        inputState = view.findViewById(R.id.input_state);
        inputZipcode = view.findViewById(R.id.input_zipcode);
        textCountry = view.findViewById(R.id.text_country);
        buttonDelete = view.findViewById(R.id.button_delete);
        view.setClickable(true);
    }

}
