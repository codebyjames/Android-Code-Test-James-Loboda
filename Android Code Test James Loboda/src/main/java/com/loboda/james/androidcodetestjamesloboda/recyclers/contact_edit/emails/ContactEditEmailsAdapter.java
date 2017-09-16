package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_edit.emails;

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
import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.emails.ContactDetailsEmailsRowHolder;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryEditContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactEditEmailsAdapter extends RecyclerView.Adapter<ContactEditEmailsRowHolder>{

    public ContactEditEmailsAdapter(){

    }

    @Override
    public ContactEditEmailsRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email_edit, parent, false);
        return new ContactEditEmailsRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactEditEmailsRowHolder holder, int position) {

        String email = "";
        try {
            email = TemporaryEditContact.editEmailList.get(position).getEmail();
        } catch (Exception ex) {
            email = "";
        }

        // set views
        holder.inputEmail.setText(email);

        // detect change
        detectTextChange(holder.inputEmail, position);

        // delete (200ms delay)
        onClickDelete(holder.buttonDelete, position, 200);

    }

    @Override
    public int getItemCount() {
        return TemporaryEditContact.editEmailList.size();
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

                        if (TemporaryEditContact.editEmailList.size() > 1) {
                            TemporaryEditContact.deleteEmail(position);
                        } else {
                            Util.showToastMessage("You need at least 1 email.");
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
                TemporaryEditContact.updateItemEmail(position, text);

            }
        });

    }

}
