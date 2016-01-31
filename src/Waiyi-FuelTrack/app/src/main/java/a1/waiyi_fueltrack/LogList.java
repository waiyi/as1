package a1.waiyi_fueltrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fisherman on 2016-01-27.
 */
// LogList equals to a list of entry
public class LogList {
    private List<Entry> log;

    public LogList() { this.log = new ArrayList<Entry>();  }

    public LogList(ArrayList<Entry> oldLog){
        this.log = oldLog;
    }

    public List<Entry> getLog () {  return log;    }

    public void add(Entry entry){
        log.add(entry);
    }

    public double getAccumTotal(){
        double accumTotal = 0.0;
        for(Entry entry : log){ accumTotal += entry.getTotal(); }
        return accumTotal;
    }

    public void setLog (int logIndex, Entry entry){
        this.log.set(logIndex, entry);
    }
}
