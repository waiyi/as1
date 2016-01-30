package a1.waiyi_fueltrack;

import java.util.Date;

/**
 * Created by Fisherman on 2016-01-25.
 */
public interface Logable {
    public Date getDate();
    public String getStation();
    public double getOdometer();
    public String getGrade();
    public double getAmount();
    public double getUnitCost();
    public double getTotal();
}
