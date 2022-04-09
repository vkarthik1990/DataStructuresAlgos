public class MorganStanley {

    /*****
     *
     * input = abcdefg
     * int k=2
     * output = cdefgab
     *
     * input= "abc"
     * k = 3
     * output = "bca"
     *
     * abc
     * bca
     *
     * abc
     *
     * 2%3 = 2
     * cba
     *
     abcd = > cdab
     * index % length.array
     * *****/

    public static String rotateString(String input,int k){




        StringBuffer result= new StringBuffer();
        int n=input.length();
        char[] inputArray=input.toCharArray();

        char[] sr=new char[n];

        int numRotations = k%n;

        String s1= input.substring(0,numRotations);
       String s2 = input.substring(numRotations,n);


        for(int i=0;i<n;i++){
            if((i+k)>n-1){
                int rotatedIndex = i % (n-1);
                sr[rotatedIndex]=inputArray[i];

            }else{
                sr[i+k]=inputArray[i];
            }
        }

        for(char c:sr){
            result.append(c);
        }
        return s2+s1;
    }



    public static void main(String[] args){
        //System.out.println(rotateString("abc",1));
        System.out.println(rotateString("abcdefg",2));
    }



}


