import models.Customers;
import org.junit.Test;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;
import static org.junit.Assert.*;

/**
 * Created by Istvan_Csenkey-Sinko on 7/6/2015.
 */

public class ModelTest {
    @Test
    public void customerTest(){
        running(fakeApplication(), new Runnable() {
            @Override
            public void run() {
                Customers customers = new Customers();
                customers.fisrtName = "Istvan";
                customers.lastName = "Csenkey-Sinko";
                customers.save();
                assertTrue(customers.id != null);
            }
        });


    }


}
