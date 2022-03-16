

    import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Log
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<String> reorderLines(int logFileSize, List<String> logLines)
        {
            Function<String,Boolean> isIntegerLine = line -> {
                String arr[]=line.split(" ",2);
                return Character.isDigit(arr[1].charAt(0));
            };

            Map<Boolean,List<String>> twoLists = logLines.stream().collect(Collectors.groupingBy(isIntegerLine));

            List<String> wordLines = twoLists.get(Boolean.FALSE);
            List<String> integerLines = twoLists.get(Boolean.TRUE);

            Comparator<String> byLog = (o1,o2)->{
                String[] o1Array =o1.split(" ",2);
                String[] o2Array =o2.split(" ",2);
                int result = o1Array[1].compareTo(o2Array[1]);
                if(result == 0)
                    return o1Array[0].compareTo(o2Array[0]);
                else
                    return result;


            };
            if(wordLines!=null)
                Collections.sort(wordLines,byLog);

            return Stream.concat(wordLines.stream(),integerLines.stream()).collect(Collectors.toList());




        }
        // METHOD SIGNATURE ENDS
    }


