public class FlattenTheBinaryTreeIntolinkedList {


    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }

        public void flatten(TreeNode root) {
            //base condition
            if(root==null)
            {
                return;
            }
            flatten(root.left);
            flatten(root.right);

            TreeNode leftSubtree=root.left;
            TreeNode rightSubTree=root.right;
            root.left=null;
            root.right=leftSubtree;
            TreeNode curr=root;

            while(curr.right!=null)
            {
                curr=curr.right;
            }
            curr.right=rightSubTree;



            //attach root to the left subtree && left subtree to the right subtree

        }
    }
}
