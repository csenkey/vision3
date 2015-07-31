package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Istvan_Csenkey-Sinko on 7/30/2015.
 */


@Entity
public class Store extends Model {

    @Id
    public String id;
    @Constraints.Required
    public String name;

    @OneToMany(mappedBy = "store" , cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    public List<User> employee = new ArrayList<User>();

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    public List<Customer> customers = new ArrayList<Customer>();


    public Store() {
        super();
    }

    public Store(String name) {
        this();
        this.name = name;
    }

    public static Model.Finder<Long,Store> find = new Model.Finder(Long.class, Store.class);

    public static Store create(String name){
        Store store = new Store(name);
        store.save();
        return store;
    }


    public Store addUser(User user){
        user.store = this;
        user.save();
        this.employee.add(user);
        this.save();
        return this;
    }


}
