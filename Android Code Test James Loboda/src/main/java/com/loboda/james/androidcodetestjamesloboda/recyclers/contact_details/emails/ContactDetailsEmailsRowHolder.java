package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.emails;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactDetailsEmailsRowHolder extends RecyclerView.ViewHolder{

    protected TextView textEmail;
    protected ImageView buttonDelete;

    public ContactDetailsEmailsRowHolder(View view) {
        super(view);

        textEmail = view.findViewById(R.id.text_email);
        buttonDelete = view.findViewById(R.id.button_delete);
        view.setClickable(true);
    }

}
