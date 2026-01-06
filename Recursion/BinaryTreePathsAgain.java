import java.util.ArrayList;
import java.util.List;



public class BinaryTreePathsAgain {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }


    // we have to traverse through the tree and write down al the path
    //base condition(smallest valid input)
    // induction(main logic)
    // hypothesis(iteration)

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res=new ArrayList<>();
        PreOrder(root,res, "");
        return res;
    }

    private void PreOrder(TreeNode root, List<String> res, String path) {
        //base condition
        if(root==null) return;
        //creating path
        if(path.isEmpty())
        {
            path=""+root.val;
        }
        else {
            path=path+"->"+root.val;
        }
        // adding path to the res
        if(root.left==null && root.right==null)
        {
            res.add(path);
        }

        //hypothesis
        PreOrder(root.left, res, path);
        PreOrder(root.right, res,path);


    }
}
