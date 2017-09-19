package com.loboda.james.androidcodetestjamesloboda.temp;

import android.util.Log;

import com.loboda.james.androidcodetestjamesloboda.database.Database;
import com.loboda.james.androidcodetestjamesloboda.helper.HelperPhoneLabels;
import com.loboda.james.androidcodetestjamesloboda.model.Address;
import com.loboda.james.androidcodetestjamesloboda.model.Birthday;
import com.loboda.james.androidcodetestjamesloboda.model.Contact;
import com.loboda.james.androidcodetestjamesloboda.model.Email;
import com.loboda.james.androidcodetestjamesloboda.model.Phone;
import com.loboda.james.androidcodetestjamesloboda.util.Util;
import com.loboda.james.androidcodetestjamesloboda.views.Views;
import com.loboda.james.androidcodetestjamesloboda.views.subviews.AddContactViews;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

/**
 * Created by Twaltex on 9/14/2017.
 */

public class TemporaryAddContact {

    public static Contact tempContact;
    public static List<Phone> addPhoneList;
    public static List<Address> addAddressList;
    public static List<Email> addEmailList;

    public static void setTempContact() {

        createNewContact();

        // set addresses
        addAddressList = new ArrayList<>();
        for (Address item : tempContact.getAddresses()) {
            addAddressList.add(item);
        }

        // set phones
        addPhoneList = new ArrayList<>();
        for (Phone item : tempContact.getPhones()) {
            addPhoneList.add(item);
        }

        // emails
        addEmailList = new ArrayList<>();
        for (Email item : tempContact.getEmails()) {
            addEmailList.add(item);
        }
    }

    /**
     * Temporarily create & save new contact in DB: delete on cancel, or save on done
     */
    private static void createNewContact(){

        RealmList<Address> addresses = new RealmList<>();
        addresses.add(new Address("", "", "", "", 0, "United States"));

        RealmList<Phone> phones = new RealmList<>();
        phones.add(new Phone(0, HelperPhoneLabels.TYPE_MOBILE));

        RealmList<Email> emails = new RealmList<>();
        emails.add(new Email(""));

        // open DB
        Database.realmDB.beginTransaction();

        Contact contact = Database.realmDB.createObject(Contact.class);
        contact.setValuesDB("", "");
        Birthday birthDate = Database.realmDB.createObject(Birthday.class);
        birthDate.setValues(0, 0, 0);
        contact.setBirthDate(birthDate);
        contact.getAddresses().addAll(addresses);
        contact.getPhones().addAll(phones);
        contact.getEmails().addAll(emails);

        // set temporary contact
        tempContact = contact;


        // close DB
        Database.realmDB.commitTransaction();


    }

    /**
     * Check errors before checking inside lists
     */
    public static boolean checkTempContactOutsideErrors() {

        boolean error = false;

        // name
        String firstName = AddContactViews.inputFirstName.getText().toString();
        String lastName = AddContactViews.inputLastName.getText().toString();

        if (Util.isStringEmpty(firstName) && Util.isStringEmpty(lastName)) {
            error = true;
            Util.showToastMessage("Please Enter first name, last name, or both.");
        } else if (addPhoneList.isEmpty() || addPhoneList == null) {
            error = true;
            Util.showToastMessage("Please add at least 1 phone number.");
        } else if (addEmailList.isEmpty() || addEmailList == null) {
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
        } else if (checkErrorInEmailList()) {

            error = true;

        } else if (checkErrorBirthday()) {

            error = true;

        } else {

            error = false;

        }

        return error;

    }

    public static boolean checkErrorInPhoneList(){

        boolean error = false;

        for (Phone item : addPhoneList) {

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

        for (Email item : addEmailList) {

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

    public static boolean checkErrorBirthday(){

        boolean error = false;

        String monthVal = AddContactViews.inputBirthdayMonth.getText().toString();
        String dayVal = AddContactViews.inputBirthdayDay.getText().toString();
        String yearVal = AddContactViews.inputBirthdayYear.getText().toString();


        try {

            int month, day, year;

            month = Integer.parseInt(monthVal);
            day = Integer.parseInt(dayVal);
            year = Integer.parseInt(yearVal);

            if (month > 12 || month == 0) {
                error = true;
                Util.showToastMessage("Month must be between 1 and 12");
            } else if (day > 31 || day == 0) {
                error = true;
                Util.showToastMessage("Day must be between 1 and 31");
            } else if (String.valueOf(year).length() < 4 || String.valueOf(year).length() > 4) {
                error = true;
                Util.showToastMessage("Year needs to 4 digits long");
            }

        } catch (Exception ex) {

            error = false;
            Util.showToastMessage("Birthday will not be saved if fields are empty");

        }

        return error;

    }

    public static void saveTempContact() {

        try {

            if (checkTempContactOutsideErrors()) {
                // found error do nothing
            } else {

                // check inner errors if no errors found outside
                if (checkTempContactInnerErrors()) {
                    // found error do nothing
                } else {

                    // update contact in DB
                    processSaveTempContactInDB();

                    // go back to contact layout
                    Views.showLayoutContacts();
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Util.showToastMessage("Please check all the fields.");
        }


    }

    private static void processSaveTempContactInDB() {

        // id
        long id = tempContact.getId();

        // addresses
        RealmList<Address> addresses = new RealmList<>();
        for (Address item : addAddressList) {
            addresses.add(item);
        }

        // phones
        RealmList<Phone> phones = new RealmList<>();
        for (Phone item : addPhoneList) {
            phones.add(item);
        }

        // emails
        RealmList<Email> emails = new RealmList<>();
        for (Email item : addEmailList) {
            emails.add(item);
        }

        // name
        String firstName = AddContactViews.inputFirstName.getText().toString();
        String lastName = AddContactViews.inputLastName.getText().toString();

        // birthday
        int month = getBirthMonth();
        int day = getBirthDay();
        int year = getBirthYear();

        // update item in database (since saved item when created temp contact)
        Database.updateContactToDB(id, firstName, lastName, month, day, year, addresses, phones, emails);

    }

    // region Get Methods for getting Data from Inputs
    private static int getBirthMonth(){

        int number = 0;

        try {
            number = Integer.parseInt(AddContactViews.inputBirthdayMonth.getText().toString());
        } catch (Exception ex) {
            number = 0;
        }

        return number;
    }

    private static int getBirthDay(){
        int number = 0;

        try {
            number = Integer.parseInt(AddContactViews.inputBirthdayDay.getText().toString());
        } catch (Exception ex) {
            number = 0;
        }

        return number;
    }

    private static int getBirthYear(){
        int number = 0;

        try {
            number = Integer.parseInt(AddContactViews.inputBirthdayYear.getText().toString());
        } catch (Exception ex) {
            number = 0;
        }

        return number;
    }
    // endregion

    // region Add item to list
    public static void addEmail(){

        addEmailList.add(new Email());
        updateAdapterEmails();

    }

    public static void addAddress(){

        addAddressList.add(new Address());
        updateAdapterAddresses();

    }

    public static void addPhone(){

        addPhoneList.add(new Phone());
        updateAdapterPhones();

    }
    // endregion

    // region update item in list
    public static void updateItemPhone(int position, long number, String type){

        // open DB
        Database.realmDB.beginTransaction();

        Phone phone = Database.realmDB.createObject(Phone.class);
        phone.setValues(number, type);
        addPhoneList.set(position, phone);

        // close DB
        Database.realmDB.commitTransaction();

    }

    public static void updateItemAddress(int position,String street, String street2, String city, String state, long zipcode, String country) {

        // open DB
        Database.realmDB.beginTransaction();

        Address address = Database.realmDB.createObject(Address.class);
        address.setValues(street, street2, city, state, zipcode, country);
        addAddressList.set(position, address);

        // close DB
        Database.realmDB.commitTransaction();

    }

    public static void updateItemEmail(int position, String text) {

        // open DB
        Database.realmDB.beginTransaction();

        Email email = Database.realmDB.createObject(Email.class);
        email.setValues(text);
        addEmailList.set(position, email);

        // close DB
        Database.realmDB.commitTransaction();

    }
    // endregion

    // region Remove item from list
    public static void deleteEmail(int position){

        addEmailList.remove(position);
        updateAdapterEmails();

    }

    public static void deleteAddress(int position) {

        addAddressList.remove(position);
        updateAdapterAddresses();

    }

    public static void deletePhone(int position){

        addPhoneList.remove(position);
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
        AddContactViews.addEmailsAdapter.notifyDataSetChanged();
    }

    public static void updateAdapterAddresses(){
        AddContactViews.addAddressesAdapter.notifyDataSetChanged();
    }

    public static void updateAdapterPhones(){
        AddContactViews.addPhonesAdapter.notifyDataSetChanged();
    }
    // endregion

}
