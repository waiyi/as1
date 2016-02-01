package a1.waiyi_fueltrack;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by waiyi on 1/30/16.
 */
public class LogTest extends ActivityInstrumentationTestCase2{
    public LogTest (){
        super(LogTest.class);
    }

    public void testAccumTotal(){
        LogList test1 = new LogList();
        assertEquals(0.0, test1.getAccumTotal());
        double amount = 55.2;
        double unitCost = 89.0;
        double total = amount*unitCost/100;

        Entry testEntry = new Entry("2000-01-01", "Oliver",45.9, "regular", amount, unitCost);
        test1.add(testEntry);
        assertEquals(testEntry.getTotal(), test1.getAccumTotal());
        assertTrue(Math.abs(testEntry.getTotal() - test1.getAccumTotal()) < 0.00001);
    }
}
