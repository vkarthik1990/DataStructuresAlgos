import java.util.List;

// Reference: https://www.youtube.com/watch?v=pD3cHFNyW2I
public class StringConcat {

    public int maxLength(List<String> arr){
        int[] result = new int[1];
        maxUnique(arr,0,"",result);
        return result[0];
    }

    private void maxUnique(List<String> arr, int index, String current, int[] result) {
        if(index == arr.size() && uniqueCharCount(current) > result[0]){
            result[0] = current.length();
            return;
        }
        if(index==arr.size()){
            return;
        }
        maxUnique(arr,index + 1,current,result);
        maxUnique(arr,index + 1,current+arr.get(index),result);
    }

    public int uniqueCharCount(String s){
        int[] counts=new int[26];
        for(char c:s.toCharArray()){
            if(counts[ c - 'a']++ >0) return -1;
        }
        return s.length();
    }
}
