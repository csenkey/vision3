package controllers.requests;

/**
 * Created by Istvan_Csenkey-Sinko on 7/7/2015.
 */


import play.data.validation.Constraints;

public class LoginRequest {
    @Constraints.Required
    public String name;
    @Constraints.Required
    public String password;
}
