public class isSymmetry {



       class TreeNode {
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


    public boolean isSymmetric(TreeNode root) {

           return isMirror(root,root);

    }

    private boolean isMirror(TreeNode p, TreeNode q) {

           //base condition(smallest valid input)
        if(p==null && q== null) return true;

        //induction
        if(p==null || q==null) return false;
        if(p.val!= q.val) return false;
        //hypothesis
        return isMirror(p.left,q.right) && isMirror(p.right,q.left);



    }
}
