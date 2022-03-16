import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> generateSubset(int[] nums){
        List<List<Integer>> subsets=new ArrayList<>();
       //if(nums==null || nums.length==0) return null;
        generateSubsetRecursive(0,nums,new ArrayList<Integer>(),subsets);
        return subsets;
    }

    private void generateSubsetRecursive(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subsets) {
       subsets.add(new ArrayList<>(current));
       for(int i=index;i<nums.length;i++){
           current.add(nums[i]);
           generateSubsetRecursive(i+1,nums,current,subsets);
           current.remove(current.size()-1);
       }
    }

    public static void main(String[] args){
        Subsets obj=new Subsets();
        System.out.println(obj.generateSubset(new int[]{1,2,3}));
    }
}
