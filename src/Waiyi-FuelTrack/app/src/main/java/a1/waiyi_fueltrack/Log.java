package a1.waiyi_fueltrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fisherman on 2016-01-27.
 */
// Log equals to a list of entry
public class Log {
    private List<Entry> log;

    public Log() { this.log = new ArrayList<Entry>();  }

    public List<Entry> getLog () {  return log;    }

    public void add(Entry entry){
        log.add(entry);
    }

    public double getAccumTotal(){
        double accumTotal = 0.0;
        for(Entry entry : log){ accumTotal += entry.getTotal(); }
        return accumTotal;
    }
}
