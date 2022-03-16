import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/design-underground-system
 * Question number: 1396 (Leetcode)
 * ***/

public class UndergroundSystem {

    private final String DELIMITER=",";
    private Map<Integer,Event> arrivals;
    private Map<String,Average> averages;

    public UndergroundSystem(){
        this.arrivals=new HashMap<>();
        this.averages=new HashMap<>();
    }

    public String getStationKey(String startStation,String endStation){
        return startStation+DELIMITER+endStation;
    }
    /***
     * Check-in : Map <id, Event(obj)>
     * ***/
    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id,new Event(id,stationName,t));
    }

    /***
     * Check-out : 1. get the checkin from arrival event;
     * 2. Remove the check in event from arrivals
     * 3. Create average and update the averages map. averages<id, Average(obj)>
     * ***/
    public void checkOut(int id, String stationName, int t) {
        Event arrEvent=arrivals.get(id);
        arrivals.remove(id);

        int diff = t - arrEvent.time;
        String key = getStationKey(arrEvent.stationName,stationName);

        Average avg= averages.containsKey(key) ? averages.get(key) : new Average();
        avg.updateAverage(diff);

        averages.put(key,avg);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key=getStationKey(startStation,endStation);
        Average avg= averages.containsKey(key) ? averages.get(key) : new Average();
        if(avg!=null){
            return avg.getAverage();
        }else{
            return 0.0;
        }


    }

    public class Event{
        public int id;
        public String stationName;
        public int time;

        public Event(int id,String stationName,int time){
            this.id=id;
            this.stationName=stationName;
            this.time=time;
        }
    }

    public class Average{
        public int total=0;
        public int count=0;

        public void updateAverage(int diff){
            count++;
            total+= diff;
        }

        public double getAverage(){
            return total/count;
        }

    }

}
