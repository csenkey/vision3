package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Istvan_Csenkey-Sinko on 7/6/2015.
 */

@Entity
public class Customers extends Model{

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String email;
    public String telephone;
    public Date birthday;
    public String zip;
    public String town;
    public String address;
}
