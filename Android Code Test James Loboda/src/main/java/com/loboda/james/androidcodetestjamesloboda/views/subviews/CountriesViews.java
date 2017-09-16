package com.loboda.james.androidcodetestjamesloboda.views.subviews;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.recyclers.countries.CountriesAdapter;
import com.loboda.james.androidcodetestjamesloboda.recyclers.phonelabels.PhoneLabelsAdapter;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class CountriesViews {

    private static Activity context = MainActivity.mainContext;
    public static RecyclerView recyclerListCountries;
    public static CountriesAdapter countriesAdapter;
    public static TextView textCancel, textDone;
    public static TextView textCurrentLabel;

    public static void setViews(){

        setTop();
        setBottom();

    }

    public static void setTop(){

        textCancel = context.findViewById(R.id.text_country_cancel);
        textDone = context.findViewById(R.id.text_country_done);
        textCurrentLabel = context.findViewById(R.id.text_current_country);

    }

    public static void setBottom(){

        recyclerListCountries = context.findViewById(R.id.recycler_list_countries);
        setRecyclerListPhoneLabels();

    }

    private static void setRecyclerListPhoneLabels(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        countriesAdapter = new CountriesAdapter();
        recyclerListCountries.setLayoutManager(linearLayoutManager);
        recyclerListCountries.setAdapter(countriesAdapter);

    }

}
