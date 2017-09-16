package com.loboda.james.androidcodetestjamesloboda.lists;

import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.model.Birthday;
import com.loboda.james.androidcodetestjamesloboda.model.Contact;
import com.loboda.james.androidcodetestjamesloboda.model.Email;
import com.loboda.james.androidcodetestjamesloboda.model.Phone;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.ContactsViews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class Lists {

    public static List<String> countries;
    public static List<String> phoneLabels;
    public static List<Contact> contactList;
    public static List<Contact> filteredContactList;
    public static List<Phone> phoneList;
    public static List<Address> addressList;
    public static List<Email> emailList;

    public static void setAllLists(){

        setCountryList();
        setPhoneLabels();
        setContactList();

    }

    public static void setCountryList(){

        countries = new ArrayList<>();

        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length()>0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        Collections.sort(countries);

    }

    public static void setPhoneLabels(){

        phoneLabels = new ArrayList<>();
        phoneLabels.add(HelperPhoneLabels.TYPE_MOBILE);
        phoneLabels.add(HelperPhoneLabels.TYPE_HOME);
        phoneLabels.add(HelperPhoneLabels.TYPE_WORK);
        phoneLabels.add(HelperPhoneLabels.TYPE_HOME_FAX);
        phoneLabels.add(HelperPhoneLabels.TYPE_WORK_FAX);
        phoneLabels.add(HelperPhoneLabels.TYPE_OTHER);

    }

    public static void setContactList(){

        contactList = new ArrayList<>();
        phoneList = new ArrayList<>();
        addressList = new ArrayList<>();
        emailList = new ArrayList<>();
        Database.getContactsFromDB();

        generateSampleContacts();

        // set filtered list
        setFilteredContactList();

    }

    public static void setFilteredContactList(){

        filteredContactList = new ArrayList<>();
        filteredContactList.addAll(contactList);

        // sort
        Collections.sort(filteredContactList);

    }

    public static void updateContactList(){
        Database.getContactsFromDB();
        setFilteredContactList();
        ContactsViews.contactsAdapter.notifyDataSetChanged();
    }

    /**
     * Generate sample contacts if list is empty
     */
    private static void generateSampleContacts(){

        if (contactList.isEmpty() || contactList == null || contactList.size() < 1) {

            // addresses
            RealmList<Address> addresses = new RealmList<>();
            addresses.add(new Address("111 Red Stuff", "Apt. 2", "Philadelphia", "PA", 19402L, "United States"));
            addresses.add(new Address("45 Blue Stuff", "Apt. 3", "Philadelphia", "PA", 19572L, "United States"));

            // phones
            RealmList<Phone> phones = new RealmList<>();
            phones.add(new Phone(4073365873L, HelperPhoneLabels.TYPE_MOBILE));
            phones.add(new Phone(5704555073L, HelperPhoneLabels.TYPE_HOME));

            // emails
            RealmList<Email> emails = new RealmList<>();
            emails.add(new Email("codebyjames@gmail.com"));

            // name
            String firstName = "James";
            String lastName = "Loboda";

            // birthday
            int month = 7;
            int day = 12;
            int year = 1993;

            // three contacts
            Database.saveContactToDB(firstName, lastName, month, day, year, addresses, phones, emails);
            Database.saveContactToDB("Two " + firstName, "What " + lastName, month, day, year, addresses, phones, emails);
            Database.saveContactToDB("Four " + firstName, "Some " + lastName, month, day, year, addresses, phones, emails);

        }

    }

}
