import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharByFrequency {

    public static void main(String[] args){
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s){
        StringBuilder result=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
            for(char c: s.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        PriorityQueue<Character> maxheap=new PriorityQueue<>((a,b) -> (map.get(b)-map.get(a))   );
        maxheap.addAll(map.keySet());
            while(!maxheap.isEmpty()){
                char currentChar=maxheap.remove();
                for(int i=0;i<map.get(currentChar);i++){
                    result.append(currentChar);
                }
            }

        return result.toString();
    }

}
