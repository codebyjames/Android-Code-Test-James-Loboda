package com.loboda.james.androidcodetestjamesloboda.recyclers.contact_details.emails;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.loboda.james.androidcodetestjamesloboda.R;
import com.loboda.james.androidcodetestjamesloboda.animation.AnimationObject;
import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class ContactDetailsEmailsAdapter extends RecyclerView.Adapter<ContactDetailsEmailsRowHolder>{

    public ContactDetailsEmailsAdapter(){

    }

    @Override
    public ContactDetailsEmailsRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email, parent, false);
        return new ContactDetailsEmailsRowHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactDetailsEmailsRowHolder holder, int position) {

        String email = Lists.emailList.get(position).getEmail();

        // set views
        holder.textEmail.setText(email);

        // delete (200ms delay)
        onClickDelete(holder.buttonDelete, position, 200);

    }

    @Override
    public int getItemCount() {
        return Lists.emailList.size();
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

                        if (Lists.emailList.size() > 1) {

                            Database.deleteEmailFromDB(TrackContact.currentEditId, position);
                            ContactDetailsEmailsAdapter.this.notifyDataSetChanged();

                        } else {
                            Util.showToastMessage("Must have at least 1 email.");
                        }

                    }
                };

                handler.postDelayed(runnable, delay);

            }
        });

    }

}
