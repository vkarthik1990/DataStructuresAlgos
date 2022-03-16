import java.util.PriorityQueue;
//Reference : https://www.youtube.com/watch?v=zLcNwcR6yO4
public class mergeKsorted {

    public class ListNode {
        int val;
        ListNode next;


        ListNode(int x) {this.val =x;}
    }

    public  ListNode mergerKlist(ListNode[] lists){
        PriorityQueue<Integer> minhHeap = new PriorityQueue<>();
        for(ListNode head:lists){
            while (head!=null){
                minhHeap.add(head.val);
                head=head.next;
            }

        }
        ListNode dummy = new ListNode(-1);
        ListNode head =dummy;
        while(!minhHeap.isEmpty()){
            head.next=new ListNode(minhHeap.remove());
            head=head.next;
        }
            return dummy.next;
    }
}
