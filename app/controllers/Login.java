package controllers;

import models.User;
import play.data.Form;
import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

/**
 * Created by Istvan_Csenkey-Sinko on 7/7/2015.
 */
public class Login extends Controller {

    public  Result login() {
        return ok(
                login.render(Form.form(LoginForm.class))
        );
    }

    public Result authenticate() {
        Form<LoginForm> loginForm = Form.form(LoginForm.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("user", loginForm.get().username);
            return redirect(
                    routes.Application.index()
            );
        }
    }


    public static class LoginForm {
        @Constraints.Required
        public String username;
        @Constraints.Required
        public String password;


        public String getName() {
            return username;
        }

        public void setName(String name) {
            this.username = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        public String validate() {
            if (User.authenticate(username, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
    }

    public Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.Login.login()
        );
    }
}
