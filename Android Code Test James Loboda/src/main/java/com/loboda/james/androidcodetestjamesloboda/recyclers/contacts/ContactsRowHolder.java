package com.loboda.james.androidcodetestjamesloboda.recyclers.contacts;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactsRowHolder extends RecyclerView.ViewHolder{

    protected CardView root;
    protected TextView textName;
    protected ImageView buttonDelete;

    public ContactsRowHolder(View view) {
        super(view);

        root = view.findViewById(R.id.root);
        textName = view.findViewById(R.id.text_name);
        buttonDelete = view.findViewById(R.id.button_delete);
        view.setClickable(true);
    }

}
