package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Istvan_Csenkey-Sinko on 7/6/2015.
 */

@Entity
public class Customer extends Model{

    @Id
    public String id;
    @Constraints.Required
    public String firstName;
    @Constraints.Required
    public String lastName;
    @Constraints.Required
    @Constraints.Email
    public String email;
    @Constraints.Required
    public String telephone;
    @Constraints.Required
    public Date birthday;
    @Constraints.Required
    public String zip;
    @Constraints.Required
    public String town;
    @Constraints.Required
    public String address;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    public List<PreviousGlass> previousGlasses;
}
