package Tree.DFS;

public class CountGoodNodes {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode()
        {
        }

        public TreeNode(int val)
        {
            this.val=val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;

        }
    }

    //intutive solution would be DFS because we are into deep, travelling from root node to leaf node
    int count=0;
    public int goodNodes(TreeNode root) {
        //keep a count of max number encountered in a path
        //(nodes, max element so far)

        if(root==null)
        {
            return 0;
        }
       dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode root, int max_so_far) {
        //maintain the node and its max value
        if(root==null)
        {
            return;
        }
        //condition for good nodes?
        //if(node.val<=max_so_far)
        if(root.val>=max_so_far)
        {
            count++;
        }
        max_so_far=Math.max(max_so_far, root.val);
        //move left
        dfs(root.left, max_so_far);

        //move right
        dfs(root.right, max_so_far);

    }


    public static void main(String[] args) {

    }
}
