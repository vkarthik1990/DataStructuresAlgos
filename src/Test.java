import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){
        String helpText = "Product item is the best Product? ";
        List<String> wordsToExclude = new ArrayList<>();
        Map<String,Integer> countMap=new TreeMap<>();
        wordsToExclude.add("is");
        wordsToExclude.add("the");
        String[] keywords=helpText.split(" ");
        for(String word:keywords){
            word= word.replaceAll("[-+.!#;,?:]","");
            if(!wordsToExclude.contains(word)) countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        int max= Collections.max(countMap.values());
        System.out.println(

                countMap.entrySet().stream().filter(entry -> entry.getValue() ==max)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList())
        );

        List<String> output=new ArrayList<>(countMap.keySet());

   Collections.sort(output,(a,b)-> (countMap.get(a)).equals(countMap.get(b))? a.compareTo(b):countMap.get(b)-countMap.get(a));
System.out.println(output);
    }




}
