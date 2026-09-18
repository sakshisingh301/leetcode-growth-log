package Tree.DFS;

public class PathSum {

    class TreeNode
    {
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

        public TreeNode (int val, TreeNode left, TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return false;
        }
        return dfs(root,targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int sumSoFar) {

        if(root==null)
        {
            return false;
        }
        sumSoFar=sumSoFar+ root.val;

        //logic to check if the combined paths are equal to targetSum
        if(root.left==null && root.right==null && sumSoFar==targetSum)
        {
            return true;
        }
        //traverse left
        boolean left=dfs(root.left,targetSum, sumSoFar);
        //traverse right
        boolean right=dfs(root.right, targetSum, sumSoFar);
        return left || right;

    }
}
