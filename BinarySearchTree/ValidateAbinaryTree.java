public class ValidateAbinaryTree {

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


  //at each level you define the range and the current node has to be in the range
    public boolean isValidBST(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isBst(TreeNode root, long min, long max) {
        //base condition
        if(root==null)
        {
            return true;
        }

        //breaking condition
        if(root.val<=min || root.val>=max)
        {
            return false;
        }
        return (isBst(root.left,min,root.val) &&isBst(root.right,root.val,max));

    }

    public static void main(String[] args) {

    }
}
