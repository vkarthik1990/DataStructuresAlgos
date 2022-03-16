import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumArrays {
    /***Returns the first possible sum pair ***/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i <nums.length;i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment)) return new int[]{map.get(compliment),i};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No sum found in array");
    }
    /*** Get all the possible pairs to acheive the sum target ***/
    public Map<Integer, Integer> twoSumPairs(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int i=0;i <nums.length;i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment))  resultMap.put(map.get(compliment),i);
            map.put(nums[i],i);
        }
        return resultMap;
    }
    
    public static void main(String[] args){
        int[] str={2,4,3,1};
        SumArrays obj=new SumArrays();
        System.out.println(Arrays.toString(obj.twoSum(str,5)));
        System.out.println(obj.twoSumPairs(str,5).toString());
    }

}
