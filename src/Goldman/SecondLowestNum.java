package Goldman;

public class SecondLowestNum {

    public static int getSecondLowest(int[] nums){
        int secondLowest = Integer.MAX_VALUE;
        int firstLowest=Integer.MAX_VALUE;

        for(int n:nums){
            if(n<firstLowest){
                secondLowest=firstLowest;
                firstLowest=n;
            }
            if( n<secondLowest && n>firstLowest ){
               secondLowest=n;
            }
        }

        return secondLowest;
    }


    public static void main(String[] args) {
        int[] a={0,1,2,3,4,6,7,8};
        int[] b={100,200,300,22,44,12};

        System.out.println(getSecondLowest(a));
        System.out.println(getSecondLowest(b));

    }


}
