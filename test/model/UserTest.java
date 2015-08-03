package model;

import models.Store;
import models.User;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.*;

/**
 * Created by Istvan_Csenkey-Sinko on 7/31/2015.
 */
public class UserTest extends WithApplication{

    @Before
    public void setUp(){
        startPlay();
    }

    @Test
    public void createAndRetrieveUser() {
        Store store = Store.create("Eszik optika").addUser(new User("bob@gmail.com","secret",  "Bob"));
        User bob = User.find.where().eq("username", "bob@gmail.com").findUnique();
        assertNotNull(bob);
        assertEquals("Bob", bob.name);
    }

    @Test
    public void tryAuthenticateUser() {
        Store store = Store.create("Eszik optika").addUser(new User("bob@gmail.com", "secret", "Bob"));
        assertNotNull(User.authenticate("bob@gmail.com", "secret"));
        assertNull(User.authenticate("bob@gmail.com", "badpassword"));
        assertNull(User.authenticate("tom@gmail.com", "secret"));
    }

}
