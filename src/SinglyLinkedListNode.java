import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SinglyLinkedListNode {
    public int goalCount;
    String name;
    SinglyLinkedListNode next;
    public SinglyLinkedListNode(String name,int goalCount){
        this.goalCount=goalCount;
        this.name=name;
        this.next=null;
    }


    public static SinglyLinkedListNode listByPerformance(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {
        if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else if (list1.goalCount < list2.goalCount) {
            list1.next = listByPerformance(list1.next, list2);
            return list1;
        }else if(list1.goalCount == list2.goalCount) {
            if((list1.name).compareTo(list2.name)<0){
                list1.next = listByPerformance(list1.next, list2);
                return list1;
            }else{
                list2.next = listByPerformance(list1, list2.next);
                return list2;
            }
        }
        else {
            list2.next = listByPerformance(list1, list2.next);
            return list2;
        }

    }
    public static void main(String[] args) {
        System.out.println("zar".compareTo("sasas"));
    }
}


class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(String name,int goalCount) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(name,goalCount);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.name));
            node = node.next;
            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}


class Result {

    /*
     * Complete the 'listByPerformance' function below.
     *
     * The function is expected to return an SinglyLinkedListNode.
     * The function accepts following parameters:
     *  1. SinglyLinkedListNode list1
     *  2. SinglyLinkedListNode list2
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int goalCount;
     *     String name
     *     SinglyLinkedListNode next;
     * }
     */

    public static SinglyLinkedListNode listByPerformance(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {
        if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else if (list1.goalCount > list2.goalCount) {
            list1.next = listByPerformance(list1.next, list2);
            return list1;
        }else if(list1.goalCount == list2.goalCount) {
            if((list1.name).compareTo(list2.name)<0){
                list1.next = listByPerformance(list1.next, list2);
                return list1;
            }else{
                list2.next = listByPerformance(list1, list2.next);
                return list2;
            }
        }
        else {
            list2.next = listByPerformance(list1, list2.next);
            return list2;
        }
    }

}

 class Solution1 {

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList list1 = new SinglyLinkedList();

       /* int list1Count = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, list1Count).forEach(i -> {
            try {
                String line = bufferedReader.readLine().trim();
                if(line.contains(",")) {
                    String name = line.split(",")[0].trim();
                    int goalCount = Integer.parseInt(line.split(",")[1].trim());
                    list1.insertNode(name, goalCount);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });*/

        SinglyLinkedList list2 = new SinglyLinkedList();

       /* int list2Count = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, list2Count).forEach(i -> {
            try {
                String line = bufferedReader.readLine().trim();
                if(line.contains(",")) {
                    String name = line.split(",")[0];
                    int goalCount = Integer.parseInt(line.split(",")[1]);
                    list2.insertNode(name, goalCount);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });*/
        list2.insertNode("Don", 9);
        list2.insertNode("Birbal", 7);
        list2.insertNode("Akbar", 5);
        list2.insertNode("Amit", 4);
        list2.insertNode("Raaj", 1);
/*
* Don,9
Birbal,7
Akbar,5
Amit,4
Raaj,1
4
Smriti,8
Pooja,6
Mithali,3
Shefali,2
* */
        list1.insertNode("Smriti", 8);
        list1.insertNode("Pooja", 6);
        list1.insertNode("Mithali", 3);
        list1.insertNode("Shefali", 2);
        SinglyLinkedListNode result = Result.listByPerformance(list1.head, list2.head);
while(result!=null){
    System.out.println(result.name);
    result = result.next;

}


      //  SinglyLinkedListPrintHelper.printList(result, "->", bufferedWriter);
      //  bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
