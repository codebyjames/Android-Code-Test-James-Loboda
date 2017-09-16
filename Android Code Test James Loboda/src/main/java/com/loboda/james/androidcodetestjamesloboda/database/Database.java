package com.loboda.james.androidcodetestjamesloboda.database;

import android.content.Context;
import android.util.Log;

import com.loboda.james.androidcodetestjamesloboda.lists.Lists;
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.model.Birthday;
import com.loboda.james.androidcodetestjamesloboda.model.Contact;
import com.loboda.james.androidcodetestjamesloboda.model.Email;
import com.loboda.james.androidcodetestjamesloboda.model.Phone;
import com.loboda.james.androidcodetestjamesloboda.util.Util;

import java.util.ArrayList;
import java.util.Collections;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Use RealmDB as a database
 * Created by Twaltex on 9/13/2017.
 */

public class Database {

    public static Realm realmDB;

    public static void setRealmDB(Context context){

        Realm.init(context);
        realmDB = Realm.getDefaultInstance();

    }

    public static void getContactsFromDB(){

        try {

            Lists.contactList = new ArrayList<>();
            RealmResults<Contact> results = Database.realmDB.where(Contact.class).findAll();

            for (Contact item : results) {
                Lists.contactList.add(item);
            }

            // sort
            Collections.sort(Lists.contactList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void saveContactToDB(String firstName, String lastName, int month, int day, int year, RealmList<Address> addresses,
                                       RealmList<Phone> phones, RealmList<Email> emails){

        /**
         * How to pass RealmList<Object> to object realm
         * RealmList<Phones> phones = new RealmList<>();
         * phones.add(new Phones("2222"));
         *
         * saveContactToDB(..., phones);
         */

        try {

            if (realmDB.isInTransaction()) {
                realmDB.cancelTransaction();
            }

            // open DB
            realmDB.beginTransaction();

            Contact contact = realmDB.createObject(Contact.class);
            contact.setValuesDB(firstName, lastName);
            Birthday birthDate = realmDB.createObject(Birthday.class);
            birthDate.setValues(month, day, year);
            contact.setBirthDate(birthDate);
            contact.getAddresses().addAll(addresses);
            contact.getPhones().addAll(phones);
            contact.getEmails().addAll(emails);

            // close DB
            realmDB.commitTransaction();

            // update List
            Lists.updateContactList();


        } catch (Exception ex) {
            ex.printStackTrace();
            Util.showToastMessage("Problem saving contact. Please try again.");
        }

    }

    public static void saveEmailToDB(long id, String email){

        Contact contact = realmDB.where(Contact.class).equalTo("id", id).findFirst();

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        contact.getEmails().add(new Email(email));

        // close DB
        realmDB.commitTransaction();

        // update List
        Lists.updateContactList();

    }

    public static void savePhoneToDB(long id, String type, long number){

        Contact contact = realmDB.where(Contact.class).equalTo("id", id).findFirst();

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        contact.getPhones().add(new Phone(number, type));

        // close DB
        realmDB.commitTransaction();

        // update List
        Lists.updateContactList();

    }

    public static void saveAddressToDB(long id, String street, String street2, String city, String state, long zipcode, String country){

        Contact contact = realmDB.where(Contact.class).equalTo("id", id).findFirst();

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        contact.getAddresses().add(new Address(street, street2, city, state, zipcode, country));

        // close DB
        realmDB.commitTransaction();

        // update List
        Lists.updateContactList();

    }

    public static void updateContactToDB(long id, String firstName, String lastName, int month, int day, int year, RealmList<Address> addresses,
                                         RealmList<Phone> phones, RealmList<Email> emails){

        Contact contact = realmDB.where(Contact.class).equalTo("id", id).findFirst();

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        contact.updateValuesDB(id, firstName, lastName);
        Birthday birthDate = realmDB.createObject(Birthday.class);
        birthDate.setValues(month, day, year);
        contact.setBirthDate(birthDate);
        contact.setAddresses(addresses);
        contact.setPhones(phones);
        contact.setEmails(emails);

        // close DB
        realmDB.commitTransaction();

        // update List
        Lists.updateContactList();

    }

    public static void deleteContactFromDB(long id) {

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        RealmResults<Contact> results = realmDB.where(Contact.class).findAll();
        Contact contact = results.where().equalTo("id", id).findFirst();

        // remove contact
        contact.deleteFromRealm();

        // close DB
        realmDB.commitTransaction();

        // update List
        Lists.updateContactList();

    }

    public static void deleteEmailFromDB(long id, int position){


        Contact contact = realmDB.where(Contact.class).equalTo("id", id).findFirst();

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        Lists.emailList.remove(position);
        RealmList<Email> emails = new RealmList<>();
        for (Email item : Lists.emailList) {
            emails.add(item);
        }

        contact.setEmails(emails);

        // close DB
        realmDB.commitTransaction();

        // update List
//        Lists.emailList.no
        Lists.updateContactList();

    }

    public static void deletePhoneFromDB(long id, int position){

        Contact contact = realmDB.where(Contact.class).equalTo("id", id).findFirst();

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        Lists.phoneList.remove(position);
        RealmList<Phone> phones = new RealmList<>();
        for (Phone item : Lists.phoneList) {
            phones.add(item);
        }

        contact.setPhones(phones);

        // close DB
        realmDB.commitTransaction();

        // update List
        Lists.updateContactList();

    }

    public static void deleteAddressFromDB(long id, int position){

        Contact contact = realmDB.where(Contact.class).equalTo("id", id).findFirst();

        if (realmDB.isInTransaction()) {
            realmDB.cancelTransaction();
        }

        // open DB
        realmDB.beginTransaction();

        Lists.addressList.remove(position);
        RealmList<Address> addresses = new RealmList<>();
        for (Address item : Lists.addressList) {
            addresses.add(item);
        }

        contact.setAddresses(addresses);

        // close DB
        realmDB.commitTransaction();

        // update List
        Lists.updateContactList();

    }


}
