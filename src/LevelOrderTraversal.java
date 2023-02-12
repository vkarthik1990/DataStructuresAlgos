
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 class TreeNode{
int val;
TreeNode left;
TreeNode right;

TreeNode(int val){
    this.val=val;
}

}

//Reference : https://www.youtube.com/watch?v=XZnWETlZZ14
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result =new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> currentlevel=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode current = queue.remove();
                currentlevel.add(current.val);
                if (current.left!=null) {
                    queue.add(current.left);
                }if(current.right!=null) {
                    queue.add(current.right);
                }
            }
            result.add(currentlevel);
        }
        return result;
    }
    /*** Find max depth in the BST ***/
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;

    }

    /*** Convert sorted array to a BST ***/

        public  TreeNode sortedArraytoBST(int[] nums){
            if(nums == null || nums.length ==0) return null;
            return constructBSTRecursive(nums,0,nums.length-1);

        }

    private TreeNode constructBSTRecursive(int[] nums, int left, int right) {
            if(left > right) return null;

            int mid = left + (right - left)/2;
            TreeNode current =new TreeNode(nums[mid]);
            current.left = constructBSTRecursive(nums,left,mid-1);
            current.right = constructBSTRecursive(nums,mid+1,right);
            return current;
    }


}
