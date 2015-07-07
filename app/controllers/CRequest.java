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
}
