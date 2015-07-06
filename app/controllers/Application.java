package controllers;

import models.Customers;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

import static play.libs.Json.*;



public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addCustomer() {
        Form<Customers> form = Form.form(Customers.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest("Missing param");
        } else {
            Customers customers = form.get();
            customers.save();
            return redirect(routes.Application.index());
        }
    }

    public static Result getCustomers(){
        List<Customers> customers = new Model.Finder<String, Customers>(String.class, Customers.class).all();
        return ok(toJson(customers));
    }


}
