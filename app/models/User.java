package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Istvan_Csenkey-Sinko on 7/30/2015.
 */

@Entity
public class User extends Model {

    enum Role { Manager, Physician, ShopAssistant}

    @Id
    @Constraints.Required
    public String username;
    @Constraints.Required
    public String password;
    @Constraints.Required
    public String name;
    @Constraints.Required
    public Role role;

    @ManyToOne
    public Store store;



    public User(){
        super();
    }

    public User(String username, String password, String name, Role role) {
        this();
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public static Object authenticate(String username, String password) {
        return find.where().eq("username", username)
                .eq("password", password).findUnique();
    }

    public static Finder<String,User> find = new Finder<String,User>(
            String.class, User.class
    );
}
