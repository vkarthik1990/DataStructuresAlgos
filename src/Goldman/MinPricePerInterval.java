package Goldman;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinPricePerInterval {
    public static class PI {
        int start;
        int end;
        int price;

        public PI(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String toString() {
            return "Start: '" + this.start + "', End: '" + this.end + "', Price: '" + this.price + "'";
        }
    }

    public static void main(String[] args) {
        List<PI> input = new ArrayList<PI>() {
            {
                add(new PI(0, 4, 5));
                add(new PI(2, 8, 3));
                add(new PI(7, 11, 10));
            }
        };
        // result new PI(0, 2, 5), new PI(2, 8, 3), new PI(8, 11, 10)
        GetMinPricePerInterval(input).stream().forEach(System.out::println);
        List<PI> input2 = new ArrayList<PI>() {
            {
                add(new PI(0, 8, 5));
                add(new PI(2, 4, 3));
                add(new PI(7, 11, 10));
            }
        };
        // result new PI(0, 2, 5), new PI(2, 4, 3), new PI(4, 8, 5) new PI(8, 11, 10)
       // GetMinPricePerInterval(input2).stream().forEach(System.out::println);
        List<PI> input3 = new ArrayList<PI>() {
            {
                add(new PI(0, 3, 5));
                add(new PI(1, 2, 3));
            }
        };
        // result new PI(0, 1, 5), new PI(1, 2, 3), new PI(2, 3, 5)
       // GetMinPricePerInterval(input3).stream().forEach(System.out::println);
    }

    public static List<PI> GetMinPricePerInterval(List<PI> input){

        List<PI> result = new ArrayList<PI>();

        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();

        for(PI p:input) {

            int currentPrice = p.getPrice();
            for (int i = p.getStart(); i < p.getEnd(); i++) {
                if (map.containsKey(i)) {
                    if (map.get(i) < currentPrice) {
                        map.put(i, map.get(i));
                    } else {
                        map.put(i, currentPrice);
                    }
                } else {
                    map.put(i, currentPrice);
                }

            }
        }
            map.entrySet().stream().forEach(System.out::println);

            System.out.println("------------------------------------------------------------------\n\n");
            for(Map.Entry<Integer,Integer> item:map.entrySet()){
                if(result.size()>0){
                    PI latestItem=result.get(result.size()-1);
                    if(latestItem.getPrice()!=item.getValue()){
                       latestItem.setEnd(item.getKey());
                        result.add(new PI(item.getKey(), item.getKey() + 1, item.getValue()));
                    }else{
                        latestItem.setEnd(item.getKey()+1);
                    }

                }else{
                    result.add(new PI(item.getKey(),item.getKey()+1,item.getValue()));
                }
            }





        return result;
    }
}
