public class StringCompression {

    //Refference : https://www.youtube.com/watch?v=IhJgguNiYYk
    public int compress(char[] chars){
        int index=0;
        int i=0;
        while(i < chars.length ){
            int j=i;
            while (j <chars.length && chars[i] == chars[j] ){
                j++;
            }
            chars[index++]=chars[i];
            if(j-i > 1){
                    String count = (j-i) +"";
                    for(char c:count.toCharArray()) {
                        chars[index++] = c;
                    }
            }
            i=j;
        }
        System.out.println(chars);
        return index;
    }

    public static void main(String[] args){
        String str="abcabadfg";
        StringCompression obj=new StringCompression();

        System.out.println(obj.compress(new char[] {'a','b','b','b','b','b','b'}));

    }

}
