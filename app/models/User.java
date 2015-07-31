package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Id;

/**
 * Created by Istvan_Csenkey-Sinko on 7/30/2015.
 */
public class User extends Model {

    @Id
    @Constraints.Required
    public String username;
    @Constraints.Required
    public String password;
    @Constraints.Required
    public String name;

    public User(){}

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public static Object authenticate(String email, String password) {
        return "";
    }
}
