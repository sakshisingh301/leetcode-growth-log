package Pattern14;

class TreeNode
{
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int val)
    {
        this.val=val;
        left=null;
        right=null;
    }
}

public class ValidateABinaryTree {

    public boolean isValidBST(TreeNode root) {

        if(root==null)
        {
            return true;
        }
        return isBST(root,Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isBST(TreeNode root, Long min, Long max) {

        if(root==null)
        {
            return true;
        }
        //breaking condition
        if(root.val<=min || root.val>=max)
        {
            return false;
        }
        return isBST(root.left,min, (long) root.val) && isBST(root.right, (long) root.val,max) ;


    }
}
