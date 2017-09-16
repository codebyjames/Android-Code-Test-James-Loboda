package com.loboda.james.androidcodetestjamesloboda.recyclers.phonelabels;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.animation.AnimationObject;
import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperContacts;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contacts.ContactsRowHolder;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryEditContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackPhoneLabel;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.EditContactViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.PhoneLabelsViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class PhoneLabelsAdapter extends RecyclerView.Adapter<PhoneLabelsRowHolder>{

    public PhoneLabelsAdapter(){

    }

    @Override
    public PhoneLabelsRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone_label, parent, false);
        return new PhoneLabelsRowHolder(view);

    }

    @Override
    public void onBindViewHolder(PhoneLabelsRowHolder holder, int position) {

        String label = Lists.phoneLabels.get(position);
        holder.textLabel.setText(label);

        // click item to go to contact detail
        onClickItem(holder.root, position);

    }

    @Override
    public int getItemCount() {
        return Lists.phoneLabels.size();
    }

    private void onClickItem(final View view, final int position) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        String label = Lists.phoneLabels.get(position);
                        TrackPhoneLabel.currentPhoneLabel = label;
                        PhoneLabelsViews.textCurrentLabel.setText(label);

                    }
                };

                handler.post(runnable);

            }
        });

    }

}
