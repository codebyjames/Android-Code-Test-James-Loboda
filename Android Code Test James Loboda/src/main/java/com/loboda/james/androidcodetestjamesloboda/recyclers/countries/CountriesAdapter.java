package com.loboda.james.androidcodetestjamesloboda.recyclers.countries;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.recyclers.phonelabels.PhoneLabelsRowHolder;
import com.loboda.james.androidcodetestjamesloboda.util.TrackCountry;
import com.loboda.james.androidcodetestjamesloboda.util.TrackPhoneLabel;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.CountriesViews;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.PhoneLabelsViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountriesRowHolder>{

    public CountriesAdapter(){

    }

    @Override
    public CountriesRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountriesRowHolder(view);

    }

    @Override
    public void onBindViewHolder(CountriesRowHolder holder, int position) {

        String label = Lists.countries.get(position);
        holder.textCountry.setText(label);

        // click item to go to contact detail
        onClickItem(holder.root, position);

    }

    @Override
    public int getItemCount() {
        return Lists.countries.size();
    }

    private void onClickItem(final View view, final int position) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        String country = Lists.countries.get(position);
                        TrackCountry.currentCountry = country;
                        CountriesViews.textCurrentLabel.setText(country);

                    }
                };

                handler.post(runnable);

            }
        });

    }

}
