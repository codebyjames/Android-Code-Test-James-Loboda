package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.addresses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactDetailsAddressesRowHolder extends RecyclerView.ViewHolder{

    protected TextView textStreet, textStreet2, textCity, textState, textZip, textCountry;
    protected ImageView buttonDelete;

    public ContactDetailsAddressesRowHolder(View view) {
        super(view);

        textStreet = view.findViewById(R.id.text_street);
        textStreet2 = view.findViewById(R.id.text_street2);
        textCity = view.findViewById(R.id.text_city);
        textState = view.findViewById(R.id.text_state);
        textZip = view.findViewById(R.id.text_zipcode);
        textCountry = view.findViewById(R.id.text_country);
        buttonDelete = view.findViewById(R.id.button_delete);
        view.setClickable(true);
    }

}
