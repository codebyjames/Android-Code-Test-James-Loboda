package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_add.phones;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.animation.AnimationObject;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackPhoneLabel;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.PhoneLabelsViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactAddPhonesAdapter extends RecyclerView.Adapter<ContactAddPhonesRowHolder> {

    public ContactAddPhonesAdapter() {

    }

    @Override
    public ContactAddPhonesRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone_edit, parent, false);
        return new ContactAddPhonesRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactAddPhonesRowHolder holder, int position) {

        String type = TemporaryAddContact.addPhoneList.get(position).getType();
        long number = 0;

        try {
            number = TemporaryAddContact.addPhoneList.get(position).getNumber();
        } catch (Exception ex) {
            number = 0;
        }

        // set views
        holder.textPhoneType.setText(type);
        if (number == 0) {
            holder.inputPhoneNumber.setText("");
        } else {
            holder.inputPhoneNumber.setText("" + number);
        }

        // detect change
        detectTextChange(holder.inputPhoneNumber, position);

        // change phone type
        onClickPhoneType(holder.textPhoneType, position);

        // delete (200ms delay)
        onClickDelete(holder.buttonDelete, position, 200);

    }

    @Override
    public int getItemCount() {
        return TemporaryAddContact.addPhoneList.size();
    }

    private void onClickPhoneType(View view, final int position) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set data
                TrackPhoneLabel.previousLayout = Views.LAYOUT_ADD_CONTACT;
                TrackPhoneLabel.currentPhone = TemporaryAddContact.addPhoneList.get(position);
                TrackPhoneLabel.currentPhoneLabel = TrackPhoneLabel.currentPhone.getType();
                TrackPhoneLabel.currentPhoneIndex = position;

                // set current label
                String currentLabel = TrackPhoneLabel.currentPhoneLabel;
                PhoneLabelsViews.textCurrentLabel.setText(currentLabel);

                // go to phone label layout
                Views.showLayoutPhoneLabels();

            }
        });

    }

    private void onClickDelete(final ImageView buttonDelete, final int position, final int delay) {

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AnimationObject.grow(buttonDelete, 200, 1.1f);

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        if (TemporaryAddContact.addPhoneList.size() > 1) {
                            TemporaryAddContact.deletePhone(position);
                        } else {
                            Util.showToastMessage("You need at least 1 phone number.");
                        }

                    }
                };

                handler.postDelayed(runnable, delay);

            }
        });

    }

    /**
     * Detect text change & change data in list that contains the original data
     */
    private void detectTextChange(EditText view, final int position) {

        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String text = editable.toString();
                long number = 0;

                try {
                    number = Long.parseLong(text);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    number = 0;
                }
                TemporaryAddContact.updateItemPhone(position, number, TemporaryAddContact.addPhoneList.get(position).getType());

            }
        });

    }

}
