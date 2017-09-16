package com.loboda.james.androidcodetestjamesloboda.helper;

import android.view.View;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.AddContactViews;

/**
 * Created by Twaltex on 9/13/2017.
 */

public class HelperAddContact {

    public static void prepareEditContact() {

        TemporaryAddContact.updateAllAdapters();

        // set temporary contact while editing
        TemporaryAddContact.setTempContact();

        // set current information for views
        setNames();
        setBirthday();

    }

    public static void setNames() {

        // names
        String firstName = "";
        String lastName = "";

        // set views
        AddContactViews.inputFirstName.setText(firstName);
        AddContactViews.inputLastName.setText(lastName);

    }

    public static void setBirthday() {

        AddContactViews.inputBirthdayMonth.setText("" );
        AddContactViews.inputBirthdayDay.setText("");
        AddContactViews.inputBirthdayYear.setText("");

    }

    // Scroll the Nested Scrollview

    public static void scrollToBottomPhoneList(){

        AddContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                int position = AddContactViews.recyclerListAddPhones.getBottom();
                AddContactViews.scroll.scrollTo(0, position);
            }
        });

    }

    public static void scrollToBottomEmailList(){

        AddContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                int position = AddContactViews.recyclerListAddEmails.getBottom();
                AddContactViews.scroll.scrollTo(0, position);
            }
        });

    }

    public static void scrollToBottomAddressList(){

        AddContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                int position = AddContactViews.recyclerListAddAddresses.getBottom();
                AddContactViews.scroll.scrollTo(0, position);
            }
        });

    }

    public static void scrollToBottomNestedView(){

        AddContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                AddContactViews.scroll.fullScroll(View.FOCUS_DOWN);
            }
        });

    }

    public static void scrollToTopNestedView(){

        AddContactViews.scroll.post(new Runnable()
        {
            public void run()
            {
                AddContactViews.scroll.scrollTo(0, 0);
            }
        });

    }

}
