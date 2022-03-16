import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// reference : https://www.youtube.com/watch?v=M9cVl4d0v04
public class WordLadder {

    public int ladderLength(String beginword, String endword, List<String> wordlist){
        HashSet<String> set=new HashSet<>();
        for(String word:wordlist) set.add(word);
        if(!set.contains(endword)) return 0;
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginword);
        int level=1;

        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String currentword = queue.poll();
                char[] word_chars = currentword.toCharArray();
                for(int j=0;j<word_chars.length;j++){
                    char original_char = word_chars[j];
                    for(char c='a';c<'z';c++){
                        if(word_chars[j] == c) continue;
                        word_chars[j]=c;
                        String new_word=String.valueOf(word_chars);
                       if(new_word.equalsIgnoreCase(endword)) return level+1;
                       if(set.contains(new_word)){
                           queue.offer(new_word);
                           set.remove(word_chars);
                       }
                    }
                    word_chars[j] = original_char;
                }
            }
            level++;
        }


        return 0;
    }
}
