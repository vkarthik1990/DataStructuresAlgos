package Goldman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MostFrequentIP {

    public static void main(String[] args) {
        System.out.println("Most Frequent IP!");

        System.out.println( getMostFrequentIp(new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-20", "10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.4 - GET 2020-08-24",}));
    }

    public static List<String> getMostFrequentIp(String[] ip){
        List<String> ipList=new ArrayList<String>();
        HashMap<String,Integer> counts=new HashMap<>();

        for(String s:ip){
            String frag=s.split(" ")[0];
            counts.put(frag,counts.getOrDefault(frag,0)+1);
        }

        int maxfreq=Integer.MIN_VALUE;

        for(String c:counts.keySet()){
            System.out.println(c+"----- "+counts.get(c));
            maxfreq=Math.max(maxfreq,counts.get(c));
        }

        for(String s:counts.keySet()){
            if(counts.get(s)==maxfreq) ipList.add(s);
        }

        Collections.sort(ipList);
        return ipList;
    }
}
