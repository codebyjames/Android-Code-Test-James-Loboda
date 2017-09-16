package com.loboda.james.androidcodetestjamesloboda.helper;

import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryAddContact;
import com.loboda.james.androidcodetestjamesloboda.temp.TemporaryEditContact;
import com.loboda.james.androidcodetestjamesloboda.util.TrackCountry;
import com.loboda.james.androidcodetestjamesloboda.views.Views;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class HelperCountries {

    public static void goToPreviousLayout(){

        // go back to previous screen
        if (TrackCountry.previousLayout == Views.LAYOUT_EDIT_CONTACT) {
            Views.showLayoutEditContact();
        } else if (TrackCountry.previousLayout == Views.LAYOUT_ADD_CONTACT) {
            Views.showLayoutAddContact();
        }

    }

    public static void updateCountry(){

        String country = TrackCountry.currentCountry;
        int addressIndex = TrackCountry.currentCountryIndex;
        Address address = TrackCountry.currentAddress;

        String street = address.getStreet();
        String street2 = address.getStreet2();
        String city = address.getCity();
        String state = address.getState();
        long zip = getZip(address);

        // update
        if (TrackCountry.previousLayout == Views.LAYOUT_EDIT_CONTACT) {

            TemporaryEditContact.updateItemAddress(addressIndex, street, street2, city,
                    state,zip, country);
            TemporaryEditContact.updateAdapterAddresses();

        } else if (TrackCountry.previousLayout == Views.LAYOUT_ADD_CONTACT) {

            TemporaryAddContact.updateItemAddress(addressIndex, street, street2, city,
                    state,zip, country);
            TemporaryAddContact.updateAdapterAddresses();

        }

    }

    private static long getZip(Address address){

        long zip = 0;

        try {
            zip = address.getZipcode();
        } catch (Exception ex) {
            ex.printStackTrace();
            zip = 0;
        }

        return zip;


    }

}
