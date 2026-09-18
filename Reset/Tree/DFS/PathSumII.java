package Tree.DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        return dfs(root, targetSum,0,res, new ArrayList<Integer>());

    }



    private List<List<Integer>> dfs(TreeNode root, int targetSum, int sumSoFar, List<List<Integer>> res, ArrayList<Integer> temp) {


        if(root==null)
        {
            return res;
        }
        temp.add(root.val);
        sumSoFar=sumSoFar+ root.val;
        if(root.left==null && root.right==null &&sumSoFar==targetSum)
        {
            res.add(temp);
        }
        //traverse left
        dfs(root.left, targetSum,sumSoFar,res,temp);
        //traverse right
        dfs(root.right, targetSum,sumSoFar,res,temp);
        return res;
    }
}
