public class MinStack {
    Node top;

    public void push(int x){
        if(top==null) top=new Node(x);
        else{
            Node temp=new Node(x);
            temp.min = Math.min(top.min,x);
            temp.next = top;
            top=temp;
        }
    }
    public int min(){
        if(top ==null){
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }
        return top.min;
    }
    public int top(){
        if(top ==null){
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }
        return top.val;
    }


    public void pop(){
        if(top ==null) {
            System.out.println("Stack is empty");
            return;
        }

        top=top.next;
    }

}

class Node{
    int val;
    int min;
    Node next;

    public Node(int val){
        this.val=val;
        this.min=val;
        next = null;
    }
}
