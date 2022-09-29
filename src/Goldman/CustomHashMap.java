package Goldman;
import java.util.Objects;

import java.util.*;

public class CustomHashMap {

    /**
     * Instructions to candidate.
     * 1) Run this code in the REPL to observe its behaviour. The
     * execution entry point is main().
     * 2) Consider adding some additional tests in doTestsPass().
     * 3) Implement MyHashMap correctly.
     * 4) If time permits, some possible follow-ups.
     */


    /**
     * class MyHashMap
     * <p>
     * Associates a key-value pair in memory such that lookups
     * and inserts can be performed in O(1) time for a reasonably
     * small set of data, and scales linearly (at worst) for larger
     * sets of key-value pairs.
     * <p>
     * Each unique key is associated with one single value.
     */

    static class Pair<U, V> {
        U U;
        V V;

        public Pair(U u, V v) {
            this.U = u;
            this.V = v;
        }
    }

    private static class MyHashMap<K, V> {

        private int key_space = 2360;
        private ArrayList<Pair> result;
        //Array list is the best way to get the values in O(1)

        MyHashMap() {

        }

           /* void put(K key, V value) {
                // todo: implement
                int Key = (int) key%key_space;

                // After getting the keyspace store the input pair in the arrylist[keyspace]
                result.put(Key)=Pair(key,value);
            }

            V get(K key) {
                int Key = (int) key%key_space;
                //to retrive in O(1) we can get the key space and go to arrraylist of that keyspace index.
                return result.get(Key).V;
            }
        }

        /**
         * bool doTestsPass()
         * Runs various tests. Returns true if tests pass. Otherwise,
         * returns false.
         */
        /*public void doTestsPass() {
            // todo: implement more tests, please
            // feel free to make testing more elegant
            int[][] testCases = {{1, 2}, {3, 4}, {5, 6}};
            boolean passed = true;

            /*var map = new MyHashMap<Integer, Integer>();

            for (int[] testCase: testCases) {
                int key = testCase[0];
                int value = testCase[1];

                map.put(key, value);

                if (!Objects.equals(map.get(key), value)) {
                    System.out.printf("Test failed [%s, %s]", key, value);
                    passed = false;
                }
            }

            if (passed) {
                System.out.println("All tested passed");
            }

        }

        /**
         * Execution entry point.
         */
       /* public static void main(String[] args)
        {
            new CustomHashMap().doTestsPass();
        }*/
    }
}



