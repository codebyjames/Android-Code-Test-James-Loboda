package com.loboda.james.androidcodetestjamesloboda.clicks.subclicks;

import android.view.View;

import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.PhoneLabelsViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class PhoneLabelsClicks {

    public static void setClicks(){

        onClickCancel();
        onClickDone();

    }

    private static void onClickCancel(){

        PhoneLabelsViews.textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // go back to previous screen
                HelperPhoneLabels.goToPreviousLayout();

            }
        });

    }

    private static void onClickDone(){

        PhoneLabelsViews.textDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // update
                HelperPhoneLabels.updatePhoneLabel();

                // go back to previous screen
                HelperPhoneLabels.goToPreviousLayout();

            }
        });

    }

}
