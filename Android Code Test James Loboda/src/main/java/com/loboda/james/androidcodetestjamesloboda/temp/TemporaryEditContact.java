package com.loboda.james.androidcodetestjamesloboda.temp;

import android.os.Handler;

import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperContactDetails;
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.model.Contact;
import com.loboda.james.androidcodetestjamesloboda.model.Email;
import com.loboda.james.androidcodetestjamesloboda.model.Phone;
import com.loboda.james.androidcodetestjamesloboda.util.TrackContact;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.EditContactViews;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

/**
 * Created by Twaltex on 9/14/2017.
 */

public class TemporaryEditContact {

    public static Contact tempContact;
    public static List<Phone> editPhoneList;
    public static List<Address> editAddressList;
    public static List<Email> editEmailList;

    public static void setTempContact() {

        tempContact = TrackContact.currentContact;

        // set addresses
        editAddressList = new ArrayList<>();
        for (Address item : tempContact.getAddresses()) {
            editAddressList.add(item);
        }

        // set phones
        editPhoneList = new ArrayList<>();
        for (Phone item : tempContact.getPhones()) {
            editPhoneList.add(item);
        }

        // emails
        editEmailList = new ArrayList<>();
        for (Email item : tempContact.getEmails()) {
            editEmailList.add(item);
        }
    }

    /**
     * Check errors before checking inside lists
     */
    public static boolean checkTempContactOutsideErrors() {

        boolean error = false;

        // name
        String firstName = EditContactViews.inputFirstName.getText().toString();
        String lastName = EditContactViews.inputLastName.getText().toString();

        if (Util.isStringEmpty(firstName) && Util.isStringEmpty(lastName)) {
            error = true;
            Util.showToastMessage("Please Enter first name, last name, or both.");
        } else if (editPhoneList.isEmpty() || editPhoneList == null) {
            error = true;
            Util.showToastMessage("Please add at least 1 phone number.");
        } else if (editEmailList.isEmpty() || editEmailList == null) {
            error = true;
            Util.showToastMessage("Please add at least 1 email.");
        } else {
            error = false;
        }

        return error;

    }

    /**
     * Check errors in lists
     */
    public static boolean checkTempContactInnerErrors() {

        boolean error = false;

        if (checkErrorInPhoneList()) {
            error = true;
        } else {

            //  check error in email because no error in phone list
            if (checkErrorInEmailList()) {
                error = true;
            } else {
                // no error found
                error = false;
            }

        }

        return error;

    }

    public static boolean checkErrorInPhoneList(){

        boolean error = false;

        for (Phone item : editPhoneList) {

            try {

                String number = String.valueOf(item.getNumber());
                if (number.length() < 10) {
                    error = true;
                    Util.showToastMessage("Every phone number must contain at least 10 digits");
                    break;
                } else {
                    error = false;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                error = true;
                Util.showToastMessage("Every phone number must contain at least 10 digits");
                break;
            }

        }

        return error;

    }

    public static boolean checkErrorInEmailList(){

        boolean error = false;

        for (Email item : editEmailList) {

            String email = item.getEmail();
            if (email.length() < 5) {
                error = true;
                Util.showToastMessage("Make sure email is valid");
                break;
            } else {
                error = false;
            }

        }

        return error;

    }

    public static void updateTempContact() {

        try {

            if (checkTempContactOutsideErrors()) {
                // found error do nothing
            } else {

                // check inner errors if no errors found outside
                if (checkTempContactInnerErrors()) {
                    // found error do nothing
                } else {

                    // update contact in DB
                    processUpdateTempContactInDB();

                    // go back to contact detail layout
                    Views.showLayoutContactDetails();

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Util.showToastMessage("Please check all the fields.");
        }


    }

    private static void processUpdateTempContactInDB() {

        // id
        long id = tempContact.getId();

        // addresses
        RealmList<Address> addresses = new RealmList<>();
        for (Address item : editAddressList) {
            addresses.add(item);
        }

        // phones
        RealmList<Phone> phones = new RealmList<>();
        for (Phone item : editPhoneList) {
            phones.add(item);
        }

        // emails
        RealmList<Email> emails = new RealmList<>();
        for (Email item : editEmailList) {
            emails.add(item);
        }

        // name
        String firstName = EditContactViews.inputFirstName.getText().toString();
        String lastName = EditContactViews.inputLastName.getText().toString();

        // birthday
        int month = getBirthMonth();
        int day = getBirthDay();
        int year = getBirthYear();

        // update item in database
        Database.updateContactToDB(id, firstName, lastName, month, day, year, addresses, phones, emails);

    }

    // region Get Methods for getting Data from Inputs
    private static int getBirthMonth(){

        int number = 0;

        try {
            number = Integer.parseInt(EditContactViews.inputBirthdayMonth.getText().toString());
        } catch (Exception ex) {
            number = 0;
        }

        return number;
    }

    private static int getBirthDay(){
        int number = 0;

        try {
            number = Integer.parseInt(EditContactViews.inputBirthdayDay.getText().toString());
        } catch (Exception ex) {
            number = 0;
        }

        return number;
    }

    private static int getBirthYear(){
        int number = 0;

        try {
            number = Integer.parseInt(EditContactViews.inputBirthdayYear.getText().toString());
        } catch (Exception ex) {
            number = 0;
        }

        return number;
    }
    // endregion

    // region Add item to list
    public static void addEmail(){

        editEmailList.add(new Email());
        updateAdapterEmails();

    }

    public static void addAddress(){

        editAddressList.add(new Address());
        updateAdapterAddresses();

    }

    public static void addPhone(){

        editPhoneList.add(new Phone());
        updateAdapterPhones();

    }
    // endregion

    // region update item in list
    public static void updateItemPhone(int position, long number, String type){

        // open DB
        Database.realmDB.beginTransaction();

        Phone phone = Database.realmDB.createObject(Phone.class);
        phone.setValues(number, type);
        editPhoneList.set(position, phone);

        // close DB
        Database.realmDB.commitTransaction();

    }

    public static void updateItemAddress(int position,String street, String street2, String city, String state, long zipcode, String country) {

        // open DB
        Database.realmDB.beginTransaction();

        Address address = Database.realmDB.createObject(Address.class);
        address.setValues(street, street2, city, state, zipcode, country);
        editAddressList.set(position, address);

        // close DB
        Database.realmDB.commitTransaction();

    }

    public static void updateItemEmail(int position, String text) {

        // open DB
        Database.realmDB.beginTransaction();

        Email email = Database.realmDB.createObject(Email.class);
        email.setValues(text);
        editEmailList.set(position, email);

        // close DB
        Database.realmDB.commitTransaction();

    }
    // endregion

    // region Remove item from list
    public static void deleteEmail(int position){

        editEmailList.remove(position);
        updateAdapterEmails();

    }

    public static void deleteAddress(int position) {

        editAddressList.remove(position);
        updateAdapterAddresses();

    }

    public static void deletePhone(int position){

        editPhoneList.remove(position);
        updateAdapterPhones();

    }
    // endregion

    // region Update adapter
    public static void updateAllAdapters(){

        updateAdapterPhones();
        updateAdapterAddresses();
        updateAdapterEmails();

    }

    public static void updateAdapterEmails(){
        EditContactViews.editEmailsAdapter.notifyDataSetChanged();
    }

    public static void updateAdapterAddresses(){
        EditContactViews.editAddressesAdapter.notifyDataSetChanged();
    }

    public static void updateAdapterPhones(){
        EditContactViews.editPhonesAdapter.notifyDataSetChanged();
    }
    // endregion

}
