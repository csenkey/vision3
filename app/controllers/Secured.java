package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by Istvan_Csenkey-Sinko on 7/31/2015.
 */
public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Http.Context context) {
        return context.session().get("user");
    }

    @Override
    public Result onUnauthorized(Http.Context context) {
        return redirect(routes.Login.login());
    }
}
