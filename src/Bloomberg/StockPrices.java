package Bloomberg;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockPrices {
    public HashMap<String,List<Double>> stockPrices= null;

    public StockPrices(){
        this.stockPrices= new HashMap<String,List<Double>>();
    }


    public  void addPrice(String company,Double value){
        List<Double> val;
        if(this.stockPrices.containsKey(company)){
            val= stockPrices.get(company);
        }else{
            val=new ArrayList<>();
        }
        val.add(value);
        this.stockPrices.put(company,val);

    }

    public  List<Double> getPrices(String company,int target) throws Exception{
        if(this.stockPrices.containsKey(company)){
            List<Double> res  = new ArrayList<>();
            List<Double> temp = stockPrices.get(company);
                /*
                int cnt=0;
                for(Double d: stockPrices.get(company)){
                    if(cnt<target) res.add(d);
                    cnt++;
                }
                */
            target = (target>temp.size()-1) ? temp.size() : target;
            for(int i=0 ; i < target ; i++){
                res.add(temp.get(i));
            }
            return res;
        }else{
            System.out.println("Invalid company");
            return null;
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        StockPrices StockPrices =new StockPrices();
        StockPrices.addPrice("IBM", 1.1);
        StockPrices.addPrice("IBM", 1.2);
        StockPrices.addPrice("IBM", 1.3);
        StockPrices.addPrice("TSLA", 17.0);
        StockPrices.addPrice("TSLA", 17.1);
        StockPrices.addPrice("TSLA", 17.1);

        System.out.println(StockPrices.getPrices("IBM", 2));    // returns [1.1, 1.2]
        System.out.println(StockPrices.getPrices("TSLA", 20));  // returns [17.0, 17.1]
    }

}

