package controllers;

import com.avaje.ebean.Ebean;
import models.Customer;
import models.PreviousGlass;
import models.User;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Yaml;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.addcustomer;

import java.util.Arrays;
import java.util.List;

import static play.libs.Json.toJson;



public class Application extends Controller {

    @Security.Authenticated(Secured.class)
    public Result index() {

            return ok(addcustomer.render("Your new application is ready.", User.find.byId(request().username())));

    }

    public  Result addCustomer() {
        Form<Customer> form = Form.form(Customer.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest("Bad request");
        } else {
            Customer customers = form.get();
            customers.save();
            return redirect(routes.Application.index());
        }
    }
    public  Result addCustomer2() {
        Form<CRequest> form = Form.form(CRequest.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest("Kiscica");
        } else {
            System.out.println("I am here");

            Customer customers = new Customer();
            CRequest cRequest = form.get();
            customers.firstName = cRequest.firstName;
            customers.birthday = cRequest.birthday;




            PreviousGlass glass = new PreviousGlass();
            glass.name = "Nice";


            customers.previousGlasses = Arrays.asList(glass);


            //glass.save();
            customers.save();
            return redirect(routes.Application.index());
        }
    }

    public  Result getCustomers(){
        List<Customer> customers = new Model.Finder<String, Customer>(String.class, Customer.class).all();
        return ok(toJson(customers));
    }


    public Result init(){
      //  Store store = Store.create("Eszik optika").addUser(new User("bob","secret",  "Bob"));
        Ebean.save((List) Yaml.load("init-data.yml"));
        return ok("init done");
    }








}
