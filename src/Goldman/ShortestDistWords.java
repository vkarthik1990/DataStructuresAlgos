package Goldman;

public class ShortestDistWords {

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1=Integer.MIN_VALUE;
        int i2=Integer.MIN_VALUE;
        int n=wordsDict.length-1;
        int min=0;
        for(int i=0;i<=n;i++){

            if(wordsDict[i].equals(word1)){
                i1=i;
            }
            if(wordsDict[i].equals(word2)){
                i2=i;
            }
            if(i1!=Integer.MIN_VALUE && i2!=Integer.MIN_VALUE) min=Math.min(min,Math.abs(i1-i2));

        }
        return min;
    }
    public static void main(String[] args) {

        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},"coding","practice"));

    }

}
