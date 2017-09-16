package com.loboda.james.androidcodetestjamesloboda.clicks.subclicks;

import android.view.View;

import com.loboda.james.androidcodetestjamesloboda.helper.HelperCountries;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.CountriesViews;


/**
 * Created by Twaltex on 9/12/2017.
 */

public class CountriesClicks {

    public static void setClicks(){

        onClickCancel();
        onClickDone();

    }

    private static void onClickCancel(){

        CountriesViews.textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // go back to previous screen
                HelperCountries.goToPreviousLayout();

            }
        });

    }

    private static void onClickDone(){

        CountriesViews.textDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // update
                HelperCountries.updateCountry();

                // go back to previous screen
                HelperCountries.goToPreviousLayout();

            }
        });

    }
}
