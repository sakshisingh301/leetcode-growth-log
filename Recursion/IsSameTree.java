public class IsSameTree {
    public static class TreeNode {
        int val;
     TreeNode left;
     TreeNode right;

        TreeNode(int val) {
            this.val = val;
            right = null;
            left = null;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //base condition
        if(p==null && q==null) return true;
        //i got stuck here
       if(p==null || q==null) return false;
       if(p.val!=q.val) return false;
       return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {

    }
}
