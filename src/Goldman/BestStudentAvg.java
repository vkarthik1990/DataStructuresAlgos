package Goldman;

import java.util.HashMap;
import java.util.Map;

public class BestStudentAvg {

    static class Student {
        String name;
        int mark;
        int count;

        public Student(String name, int mark, int count) {
            this.name = name;
            this.mark = mark;
            this.count = count;
        }
    }


    public static void main(String[] args) {
        String input[][] = {{"Bob","87"}, {"Jessica", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};
        System.out.println(findMaxAverage(input));
    }

    private static int findMaxAverage(String[][] input) {
        Integer max=Integer.MIN_VALUE;
        Map<String,Student> map = new HashMap<>();
        for(String[] r: input) {
            if(map.containsKey(r[0])) {
                Student t = map.get(r[0]);
                map.put(r[0],new Student(r[0],t.mark+ Integer.parseInt(r[1]), t.count+1));
                max = Math.max((t.mark+Integer.parseInt(r[1]))/(t.count+1), max);
            }else {
                map.put(r[0], new Student(r[0], Integer.parseInt(r[1]), 1));
                max =Math.max(Integer.parseInt(r[1]), max);
            }
        }
        System.out.println(max);

        return max;
    }

}
