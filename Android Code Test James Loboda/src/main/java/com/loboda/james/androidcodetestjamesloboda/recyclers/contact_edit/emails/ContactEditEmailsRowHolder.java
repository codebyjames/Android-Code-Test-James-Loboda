package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_edit.emails;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactEditEmailsRowHolder extends RecyclerView.ViewHolder{

    protected EditText inputEmail;
    protected ImageView buttonDelete;

    public ContactEditEmailsRowHolder(View view) {
        super(view);

        inputEmail = view.findViewById(R.id.input_email);
        buttonDelete = view.findViewById(R.id.button_delete);
        view.setClickable(true);
    }

}
