import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode balanceBST(TreeNode root) {

        //inorder traversal
        List<Integer> inorder=new ArrayList<>();

        inorderTraversal(root, inorder);
        return createBstFromInorder(inorder, 0, inorder.size()-1);

    }


    //a magic function which creates the BST
    private TreeNode createBstFromInorder(List<Integer> inorder, int start, int end) {
      if(start>end)
          return null;

        //find mid
        int mid=start+(end-start)/2;
        //construct left subtree
        TreeNode left= createBstFromInorder(inorder, start, mid-1);
        TreeNode right= createBstFromInorder(inorder, mid+1, end);

        //Create Node
        TreeNode node =new TreeNode(inorder.get(mid),left,right );
        return node;




    }

    private void inorderTraversal(TreeNode root, List<Integer> inorder) {

        //base condition
        if(root==null)
        {
            return;
        }
        inorderTraversal(root.left,inorder);
        inorder.add(root.val);
        inorderTraversal(root.right,inorder);
    }


}
