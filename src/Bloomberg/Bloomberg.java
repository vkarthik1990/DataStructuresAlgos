package Bloomberg;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bloomberg {

    public static class Transaction{
        String name;
        int Amount;
        int mins;
        String Location;

        public Transaction( String transaction){

            this.Amount=Integer.parseInt(transaction.split(",")[1]);
            this.name=transaction.split(",")[0];
            this.mins=Integer.parseInt(transaction.split(",")[2]);
            this.Location=transaction.split(",")[3];
        }
    }
    public static void main(String[] transcationStrings) {


        Map<String,Transaction> transMap= new HashMap<>();
        Set<Transaction> result=new HashSet<>();
        for(String s:transcationStrings ){
            String key=s.split(",")[0];
            Transaction obj = new Transaction(s);
            if(transMap.containsKey(obj.name)) {

                //Validate if two locations are diff & time diff less than hr
                if(checkDiffLoc(transMap.get(obj.name),obj)){
                    Transaction prev=transMap.get(obj.name);
                    result.add(obj);
                    result.add(prev);
                }


            }

            if(checkAmtThresold(obj.Amount)){
                result.add(obj);
            }


            transMap.put(obj.name, obj);
        }

        for(Transaction t: result){
            System.out.print(t.toString());
        }

    }

    private static boolean checkDiffLoc(Transaction transaction, Transaction obj) {
        return true;
    }

    private static boolean checkAmtThresold(int amount) {
        return true;
    }


   /*
    Name, Amount, MinsPastMidNight, Location
    "David, 1050, 1, London",<-- 1
    "David, 50, 2, London",  <-- 2

    "Emily, 100, 2, London",
    "George, 800, 2, London",
    "Richard, 800, 30, Prague",
    "David, 1000, 60, Paris",
    "George, 800, 800, London",
    "Emily, 800, 800, New York",
    "Tom, 1100, 850, New York",
    "Emily, 800, 859, Paris",

   */

    //https://media.istockphoto.com/vectors/slot-fruit-machine-vector-id125189403

}
