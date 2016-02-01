package a1.waiyi_fueltrack;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by waiyi on 1/30/16.
 */
public class EntryTest extends ActivityInstrumentationTestCase2 {
    public EntryTest(){
        super(EntryTest.class);

    }

    public void testUpdateTotalCost(){
        double amount = 55;
        double unitCost = 64.9;
        double total = amount*unitCost/100;

        Entry testEntry = new Entry("2011-10-31", "oxford", 60.2, "premium", amount, unitCost, total);

        assertTrue(Math.abs(total - testEntry.getTotal())<0.00001);
    }
}
