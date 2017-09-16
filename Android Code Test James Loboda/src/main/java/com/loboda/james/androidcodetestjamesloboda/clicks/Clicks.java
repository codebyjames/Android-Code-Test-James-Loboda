package com.loboda.james.androidcodetestjamesloboda.clicks;

import com.loboda.james.androidcodetestjamesloboda.clicks.subclicks.AddContactClicks;
import com.loboda.james.androidcodetestjamesloboda.clicks.subclicks.ContactsClicks;
import com.loboda.james.androidcodetestjamesloboda.clicks.subclicks.ContactDetailsClicks;
import com.loboda.james.androidcodetestjamesloboda.clicks.subclicks.CountriesClicks;
import com.loboda.james.androidcodetestjamesloboda.clicks.subclicks.EditContactClicks;
import com.loboda.james.androidcodetestjamesloboda.clicks.subclicks.PhoneLabelsClicks;

/**
 * Set clicks for the layouts
 * Created by Twaltex on 9/12/2017.
 */

public class Clicks {

    public static void setContactsClicks(){
        ContactsClicks.setClicks();
    }

    public static void setContactDetailsClicks(){
        ContactDetailsClicks.setClicks();
    }

    public static void setEditContactClicks(){
        EditContactClicks.setClicks();
    }

    public static void setCountriesClicks(){
        CountriesClicks.setClicks();
    }

    public static void setPhoneLabelsClicks() {
        PhoneLabelsClicks.setClicks();
    }

    public static void setAddContactClicks() {
        AddContactClicks.setClicks();
    }

}
