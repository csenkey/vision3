package controllers;

import controllers.requests.LoginRequest;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Istvan_Csenkey-Sinko on 7/7/2015.
 */
public class Login extends Controller {

    public static Result login(){
        Form<LoginRequest> form = Form.form(LoginRequest.class).bindFromRequest();
        if(form.hasErrors()){
            return badRequest("oops something wrong");
        }else{
            LoginRequest request = form.get();
            session("connected", request.name);
            return redirect(routes.Application.index());
        }
    }
}
