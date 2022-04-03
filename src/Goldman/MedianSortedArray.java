package Goldman;

public class MedianSortedArray {

    /***
     * LEETCODE :4 (HARD)
     * Example 1:
     *
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     *
     *
     * Time Complexity : O(M+N)
     */

    public static double getMedian(int[] num1,int[] num2){
        int i=0,j=0,k=0;
        int n= num2.length;
        int m=num1.length;
        int[] a = new int[n+m];

        /***** Merge two sorted arrays into one sorted array ******/

        while(i<m && j<n){
            if(num1[i]<num2[j]){
                a[k]=num1[i];
                i++;
            }else{
                a[k]=num2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            a[k]=num1[i];
            i++;
            k++;
        }
        while(j<n){
            a[k]=num2[j];
            j++;
            k++;
        }

        /***Fetch the median based on odd or even n+m ****/
        if((m+n)%2!=0){
            return a[m+n/2];
        }else{
            int x=m+n/2;
            return (a[x]+a[x-1])/2;
        }

    }
}
