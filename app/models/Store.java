package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Istvan_Csenkey-Sinko on 7/30/2015.
 */
public class Store extends Model {

    @Id
    public String id;
    @Constraints.Required
    public String name;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    public List<User> employee;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    public List<Customer> customers;

}
