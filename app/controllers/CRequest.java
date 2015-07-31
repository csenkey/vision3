package controllers;

import play.data.validation.Constraints;

import java.util.Date;

/**
 * Created by Istvan_Csenkey-Sinko on 7/7/2015.
 */
public class CRequest {
    public String id;

    @Constraints.Required
    public String firstName;
    @Constraints.Required
    public String lastName;
    @Constraints.Required
    @Constraints.Email
    public String email;
    @Constraints.Required
    public String telephone;
    @Constraints.Required
    public Date birthday;
    @Constraints.Required
    public String zip;
    @Constraints.Required
    public String town;
    @Constraints.Required
    public String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
