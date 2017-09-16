package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_edit.phones;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactEditPhonesRowHolder extends RecyclerView.ViewHolder{

    protected TextView textPhoneType;
    protected EditText inputPhoneNumber;
    protected ImageView buttonDelete;

    public ContactEditPhonesRowHolder(View view) {
        super(view);

        textPhoneType = view.findViewById(R.id.text_phone_type);
        inputPhoneNumber = view.findViewById(R.id.input_phone_number);
        buttonDelete = view.findViewById(R.id.button_delete);
        view.setClickable(true);
    }

}
