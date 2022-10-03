package Goldman;

import java.io.IOException;

public class ReverseLinkedLst {

    public class ListNode{
        int val;
        ListNode next;

    }

    public ListNode reverseLinkedLst(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        if(curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }

        return prev;
    }

    public ListNode reverseLinkedLst_recurssion(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseLinkedLst_recurssion(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
    public static void main(String[] args) throws IOException {

    }
}
