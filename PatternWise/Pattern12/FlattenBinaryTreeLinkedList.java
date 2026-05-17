package Pattern12;

public class FlattenBinaryTreeLinkedList {

    public void flatten(TreeNode root) {
        //base condition
        if(root==null)
        {
            return;
        }
        //hypothesis
        flatten(root.left);
        flatten(root.right);
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        root.right=left;
        TreeNode curr=root;
        while(curr.right!=null)
        {
            curr=curr.right;
        }
        curr.right=right;


    }
}
