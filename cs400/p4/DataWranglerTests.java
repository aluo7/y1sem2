// --== CS400 P3 File Header ==--
// Name: Alan Luo
// CSL Username: aluo
// Email: aluo7@wisc.edu
// Lecture #: 001

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * tester class for the Data Wrangler's implementation of classes
 */
public class DataWranglerTests {

    /**
     * tests to see that routes are instantiated properly
     * 
     * @return true if all tests are passed, false otherwise
     */
    @Test
    public void test1() {
        Route r1 = new Route("Maddie", "09:06", "Kensington Dr", "Lake Zurich");

        assertEquals("Maddie", r1.getName());
        assertEquals("09:06", r1.getTime());
        assertEquals("Kensington Dr", r1.getPassengerLocation());
        assertEquals("Lake Zurich", r1.getDriverLocation());
    }

    /**
     * tests to see that the compareTo method works properly
     * 
     * @return true if all tests are passed, false otherwise
     */
    @Test
    public void test2() {
        Route r1 = new Route("Maddie", "12:04", "Kensington Dr", "Lake Zurich");
        Route r2 = new Route("Maddie", "12:36", "Kensington Dr", "Lake Zurich");
        Route r3 = new Route("Sabrina", "04:32", "Regent St", "Observatory Dr");

        assertEquals(0, r1.compareTo(r1));

        assertTrue(r1.compareTo(r2) > 0);

        assertTrue(r1.compareTo(r3) < 0);
    }

    /**
     * tests to see that the .json file is parsed properly, and that the returned
     * array is the correct size
     * 
     * @return true if all tests are passed, false otherwise
     */
    @Test
    public void test3() {
        List<IRoute> list = new ArrayList<IRoute>();

        try {
            list = RouteLoader
                    .loadRoutes("C:\\Users\\luoal\\OneDrive\\Documents\\year1sem2\\cs400\\p3w13\\routes.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(25, list.size());
    }

    /**
     * tests to see that the .json file is parsed properly, and that the Route
     * objects within the file contain the correct data values
     * 
     * @return true if all tests are passed, false otherwise
     */
    @Test
    public void test4() {
        List<IRoute> list = new ArrayList<IRoute>();

        try {
            list = RouteLoader
                    .loadRoutes("C:\\Users\\luoal\\OneDrive\\Documents\\year1sem2\\cs400\\p3w13\\routes.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("Madeline Mitchell", list.get(0).getName());
        assertEquals("09:06", list.get(0).getTime());

        assertEquals("Sabrina Oh", list.get(1).getName());
        assertEquals("26th St", list.get(1).getPassengerLocation());

        assertEquals("Jusleen Bindra", list.get(2).getName());
        assertEquals("Green Bay Rd", list.get(2).getDriverLocation());
    }

    /**
     * tests to see that the correct exception is thrown when the wrong directory is
     * inputted into the loadRoutes method
     * 
     * @return true if all tests are passed, false otherwise
     */
    @Test
    public void test5() {
        List<IRoute> list = new ArrayList<IRoute>();
        boolean testException = false;

        try {
            list = RouteLoader.loadRoutes("c:\\wrong\\directory.json");
        } catch (IOException e) {
            testException = true;
        }

        assertTrue(testException);
    }
}
