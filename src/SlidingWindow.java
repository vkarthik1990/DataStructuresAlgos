import java.util.HashSet;
import java.util.Set;
// REFERENCE : https://www.youtube.com/watch?v=MK-NZ4hN7rs
public class SlidingWindow {

    public int findSmallestSumSubArray(int[] arr, int target){
        if(arr == null || arr.length==0) return 0;
        int minWindowSize=Integer.MAX_VALUE;
        int currentsum=0,windowstart=0;
        for(int windowstend = 0; windowstend< arr.length;windowstend++){
            currentsum +=arr[windowstend];
            while(currentsum >= target){
                minWindowSize = Math.min(minWindowSize,windowstend-windowstart+1) ;
                currentsum -=arr[windowstart];
                windowstart++;
            }
        }
        return minWindowSize;
    }



    public int findMaxSumSubArray(int[] arr, int k){
        if(arr == null || arr.length==0) return 0;
       int currentsum=0,max=0;
        for(int i=0;i<arr.length;i++){
            currentsum +=arr[i];
            if(i>=k-1) {
              max=Math.max(max,currentsum);
              currentsum-=arr[i-(k-1)];
            }
        }
        return max;
    }
    public int lengthOfLongestSubString(String s){
        if(s == null || s.length()==0) return 0;
        int i=0,j=0,max=0;
        Set<Character> set=new HashSet<>();
        while(i<s.length()){
            char c=s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(j));
                ++j;
            }
            set.add(c);
            max=Math.max(max,i-j+1);
            ++i;
        }
        return max;
    }

    public static void main(String[] args){
        String str="abcabadfg";
        SlidingWindow obj=new SlidingWindow();
        System.out.println(obj.lengthOfLongestSubString(str));
        System.out.println(obj.findMaxSumSubArray(new int[] {1,2,3,4,5,6,10},3));
        System.out.println(obj.findSmallestSumSubArray(new int[]{2,4,5,8,1,3,5},8));
    }
}
