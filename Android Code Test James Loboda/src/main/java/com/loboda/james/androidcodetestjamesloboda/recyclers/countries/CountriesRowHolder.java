package com.loboda.james.androidcodetestjamesloboda.recyclers.countries;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.R;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class CountriesRowHolder extends RecyclerView.ViewHolder{

    protected CardView root;
    protected TextView textCountry;

    public CountriesRowHolder(View view) {
        super(view);

        root = view.findViewById(R.id.root);
        textCountry = view.findViewById(R.id.text_country);
        view.setClickable(true);
    }

}
