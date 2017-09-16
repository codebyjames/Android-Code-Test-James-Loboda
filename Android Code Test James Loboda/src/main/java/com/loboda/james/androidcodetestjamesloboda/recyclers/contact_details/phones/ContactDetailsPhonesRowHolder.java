package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.phones;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactDetailsPhonesRowHolder extends RecyclerView.ViewHolder{

    protected TextView textPhoneType, textPhoneNumber;
    protected ImageView buttonDelete;

    public ContactDetailsPhonesRowHolder(View view) {
        super(view);

        textPhoneType = view.findViewById(R.id.text_phone_type);
        textPhoneNumber = view.findViewById(R.id.text_phone_number);
        buttonDelete = view.findViewById(R.id.button_delete);
        view.setClickable(true);
    }

}
