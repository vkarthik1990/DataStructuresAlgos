
import java.util.Arrays;


public class CustomArrayList<T> {
    private T t;
    private Object[] arr;
    int fixedLen=10;
    int currIndex=0;

    CustomArrayList(){
       this.arr=new Object[fixedLen] ;
    }
    /**Variable Args...**/
    CustomArrayList(String... arr){
        this.arr=arr;
    }

    public void add(T value){
        int currArrLen=this.arr.length;
        if(currArrLen==currIndex){
            increaseQuota();
        }
        this.arr[currIndex+1]=value;
        this.currIndex++;

    }

    private void increaseQuota() {
        this.arr=Arrays.copyOf(this.arr,arr.length+fixedLen);
    }

    public Object get(int index) {
        return this.arr[index];
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> intList=new CustomArrayList<Integer>();
        CustomArrayList<String> StrList=new CustomArrayList<String>();
        intList.add(102);
        intList.add(231);
        intList.add(20);
        StrList.add("Test1");
        StrList.add("Test2");
        System.out.println(intList.get(2)+"  "+StrList.get(2));

    }

}
