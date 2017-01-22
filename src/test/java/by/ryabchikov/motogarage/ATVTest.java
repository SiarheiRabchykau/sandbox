package by.ryabchikov.motogarage;

import by.ryabchikov.motogarage.mototechnictype.motorcycle.ATV;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by sergey on 22.1.17.
 */
public class ATVTest {
    protected ATV atv;

    @BeforeClass()
    public void setUp() {
        //String brand, String model, int maxSpeed, int weight, int power, int caseCapacity, double cost
        atv = new ATV("AtvBrand", "Atvmodel", 150, 300, 15, 150, 1.0);
    }

    @AfterClass()
    public void tearDown() {
        System.out.println("bla-bla");
    }
}