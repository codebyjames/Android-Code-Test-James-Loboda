package com.loboda.james.androidcodetestjamesloboda.views.subviews;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.loboda.james.androidcodetestjamesloboda.MainActivity;
import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.recyclers.phonelabels.PhoneLabelsAdapter;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class PhoneLabelsViews {

    private static Activity context = MainActivity.mainContext;
    public static RecyclerView recyclerListPhoneLabels;
    public static PhoneLabelsAdapter phoneLabelsAdapter;
    public static TextView textCancel, textDone;
    public static TextView textCurrentLabel;

    public static void setViews(){

        setTop();
        setBottom();

    }

    public static void setTop(){

        textCancel = context.findViewById(R.id.text_phone_label_cancel);
        textDone = context.findViewById(R.id.text_phone_label_done);
        textCurrentLabel = context.findViewById(R.id.text_current_phone_label);

    }

    public static void setBottom(){

        recyclerListPhoneLabels = context.findViewById(R.id.recycler_list_phone_labels);
        setRecyclerListPhoneLabels();

    }

    private static void setRecyclerListPhoneLabels(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        phoneLabelsAdapter = new PhoneLabelsAdapter();
        recyclerListPhoneLabels.setLayoutManager(linearLayoutManager);
        recyclerListPhoneLabels.setAdapter(phoneLabelsAdapter);

    }

}
