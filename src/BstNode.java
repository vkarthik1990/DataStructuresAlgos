 class BstNode {
    BstNode left, right;
    int data;

    public BstNode(int data) {
        this.data = data;
    }

    public void insert(int value){
        if(value<=data){
            if(left == null){
                left=new BstNode(value);
            }else{
                left.insert(value);
            }
        }else{
            if(right==null){
                right=new BstNode(value);
            }else{
                right.insert(value);
            }
        }
    }


    public boolean contains(int value){
        if(value == data){
            return true;
        }else if(value < data){
            if(left==null) return false;
            else return left.contains(value);
        }else{
            if(right==null) return false;
            else return right.contains(value);
        }
    }

    public void printInOrder(){
        if(left!=null){
            left.printInOrder();
        }
        System.out.print(" "+data);
        if(right!=null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.print(" "+data);
        if(left!=null){
            left.printPreOrder();
        }
        if(right!=null){
            right.printPreOrder();
        }
    }
    public void printPostOrder(){
        if(left!=null) {
            left.printPostOrder();
        }
        if(right!=null){
            right.printPostOrder();
        }
        System.out.print(" "+data);
    }



}

class BST{
    public static void main(String[] args){
        BstNode n=new BstNode(1);
        n.insert(10);
        n.insert(20);
        n.insert(30);
        n.insert(40);
       System.out.println(n.contains(10));
        n.printInOrder();
        System.out.println("\n");
        n.printPostOrder();
        System.out.println("\n");
        n.printPreOrder();
    }
}


