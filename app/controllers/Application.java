package controllers;

import controllers.requests.LoginRequest;
import models.Customer;
import models.PreviousGlass;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.login;

import java.util.List;

import static play.libs.Json.toJson;



public class Application extends Controller {

    public static Result index() {
        String user = session("connected");
        if(user == null){
            return ok(login.render(""));
        } else {
            return ok(index.render("Your new application is ready."));
        }
    }

    public static Result addCustomer() {
        Form<Customer> form = Form.form(Customer.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest("Bad request");
        } else {
            Customer customers = form.get();
            customers.save();
            return redirect(routes.Application.index());
        }
    }
    public static Result addCustomer2() {
        Form<CRequest> form = Form.form(CRequest.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest("Kiscica");
        } else {
            System.out.println("I am here");

            Customer customers = new Customer();
            CRequest cRequest = form.get();
            customers.firstName = cRequest.firstName;
            customers.birthday = cRequest.birthday;
            customers.save();

            PreviousGlass glass = new PreviousGlass();
            glass.name = "Nice";
            glass.owner = customers;

            glass.save();

            return redirect(routes.Application.index());
        }
    }

    public static Result getCustomers(){
        List<Customer> customers = new Model.Finder<String, Customer>(String.class, Customer.class).all();
        return ok(toJson(customers));
    }

    public static Result getPrevGlasses(){
        List<PreviousGlass> customers = new Model.Finder<String, PreviousGlass>(String.class, PreviousGlass.class).all();
        return ok(toJson(new LoginRequest()));
    }

}
