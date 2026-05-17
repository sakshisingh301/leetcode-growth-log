package Pattern12;



public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        //base condition
        if(root==null)
        {
            return null;
        }

        //induction
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        //hypothesis
        root.left=right;
        root.right=left;
        return root;

    }
}
