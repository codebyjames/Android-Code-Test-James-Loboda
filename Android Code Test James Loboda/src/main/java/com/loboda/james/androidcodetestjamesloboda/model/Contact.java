package com.loboda.james.androidcodetestjamesloboda.model;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class Contact extends RealmObject implements Comparable<Contact>{

    private long id;
    private String firstName, lastName;
    private Birthday birthDate;
    private RealmList<Address> addresses;
    private RealmList<Phone> phones;
    private RealmList<Email> emails;

    public Contact(){

    }

    /**
     * Set Values for Realm DB
     **/

    public void setValuesDB(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = createUniqueId();

    }

    /**
     * Set Values for Realm DB
     **/
    public void updateValuesDB(long id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Create a unique id to be used for database Id
     * @return
     */
    private long createUniqueId(){
        long currentTime = (System.currentTimeMillis());
        return currentTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Birthday getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Birthday birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(RealmList<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(RealmList<Phone> phones) {
        this.phones = phones;
    }

    public RealmList<Email> getEmails() {
        return emails;
    }

    public void setEmails(RealmList<Email> emails) {
        this.emails = emails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(@NonNull Contact contact) {
        return (this.firstName + " " + lastName).compareTo(contact.getFirstName() +
                " " + contact.getLastName());
    }
}
