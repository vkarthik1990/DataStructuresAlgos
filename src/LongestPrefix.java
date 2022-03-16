public class LongestPrefix {

    public String LongestCommonPrefix(String[] str){
        String longestPrefix="";
        if(str==null ||str.length==0){
            return longestPrefix;
        }
        int index=0;
//Take the first string and compare each character to the next string character
        for(char c: str[0].toCharArray()){
            for(int i=1;i<str.length;i++){
                if(index>=str[i].length() || c!=str[i].charAt(index)){
                    return longestPrefix;
                }
            }
            longestPrefix+=c;
            index++;
        }
        return longestPrefix;
    }


    public static void main(String[] args){
        String[] str={"flower","flow","fl"};
        LongestPrefix obj=new LongestPrefix();
        System.out.println(obj.LongestCommonPrefix(str));
    }
}
