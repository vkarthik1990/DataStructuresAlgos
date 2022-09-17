import java.util.*;

public class BofaSolution {

    public static void main(String[] args){
        List<String> ExcludeList = new ArrayList<>();
        String Input = "Hello Hello world this is karthik and foo char boo foo foo back char hello world karthik will hello";
        int k=3;
       // List<String> result=getTopWords(Input,k);
        //System.out.println(result);

        int[] inputarr={23,  27,  29,  22, 12, 13, 15};
        int MaxProfit= getMaxProfit(inputarr);
        System.out.println(MaxProfit);
    }

    private static int getMaxProfit(int[] inputarr) {
        Integer maxProfit=Integer.MIN_VALUE;
        Integer buyprice=0;
        for(int j=0;j<inputarr.length;j++){
            buyprice = inputarr[j];
            for(int i=j+1;i<inputarr.length;i++){
                Integer diff=inputarr[i]-buyprice ;
                maxProfit =Math.max(maxProfit,diff);
            }
        }

        for(int i=1;i<inputarr.length;i++){
            int tempMax = 0;
            if(i==1){
                tempMax = inputarr[1]-inputarr[0];

            }else{
                 tempMax = maxProfit-inputarr[i];
              //  maxProfit = Math.max(maxProfit,tempMax);
            }
            maxProfit = Math.max(maxProfit,tempMax);
        }

        return maxProfit;
    }


    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    private static List<String> getTopWords(String input, int k) {
        List<String> result=new ArrayList<>();
        Map<String,Integer> wordcnt=new TreeMap<>();
        //Step 1 : Parse the string and put in map
        String[] temp= (input.replaceAll("^[0-9],&/","").toLowerCase()).split(" ");
        //input.split(" ");

        for(String s:temp){
           if(wordcnt.containsKey(s)){
               int cnt=wordcnt.get(s);
              wordcnt.put(s,cnt+1);
           }else{
               wordcnt.put(s,1);
           }
        }

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        wordcnt.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

       for(String res:reverseSortedMap.keySet()){
          if(k==0) return result;
          else {
              result.add(res);
              k--;
          }
        }


        return result;
    }

    //Step 2 : Sort the Map based on the values
    //step 3:  Iterate the map with top k values and return

public static void testWordCnt(){
        // 1. Empty String or Null
    // 2. Spcial characters
    // 3. MultiLine Input
    //4. Exclude List
    //5. Negative K value
    //6. index check .. u have 3 words but u ask 5 k top words
}
}

