package Basic.Aautil;

import org.junit.Before;
import org.junit.Test;
 
import static org.junit.Assert.assertTrue;
 
public class CarUnitTest {
 
    private Car mercedes;
 
    @Before
    public void setUp() {
        mercedes = new Car(Car.Brand.MERCEDES, 50);
    }
 
    @Test
    public void test_car_drives() {
        mercedes.unlock();
        mercedes.drive(45.31, 1);
        assertTrue(mercedes.isDriving());
    }
 
}