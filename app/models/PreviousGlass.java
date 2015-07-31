package models;

import play.db.ebean.Model;

import javax.persistence.*;


/**
 * Created by Istvan_Csenkey-Sinko on 7/7/2015.
 */

@Entity
public class PreviousGlass extends Model{

    @Id
    public String id;
    public String name;


}
