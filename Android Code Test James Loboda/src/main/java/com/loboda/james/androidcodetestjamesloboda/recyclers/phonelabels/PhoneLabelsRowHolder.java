package com.loboda.james.androidcodetestjamesloboda.recyclers.phonelabels;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class PhoneLabelsRowHolder extends RecyclerView.ViewHolder{

    protected CardView root;
    protected TextView textLabel;

    public PhoneLabelsRowHolder(View view) {
        super(view);

        root = view.findViewById(R.id.root);
        textLabel = view.findViewById(R.id.text_label);
        view.setClickable(true);
    }

}
