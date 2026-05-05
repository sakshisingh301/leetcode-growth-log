import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static class TreeNode
    {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=1;

        while(!queue.isEmpty())
        {
            int queueSize= queue.size();
            List<Integer> temp=new ArrayList<>();

            for(int i=0;i<queueSize;i++)
            {
                TreeNode curr= queue.poll();
                if(curr!=null) {
                    if(curr.left!=null)
                    {
                        queue.add(curr.left);
                    }
                    if(curr.right!=null)
                    {
                        queue.add(curr.right);
                    }
                    temp.add(curr.val);
                }


            }
            if(level%2==0)
            {
                Collections.reverse(temp);
            }
            res.add(temp);
            level++;
        }
        return res;



    }

    //root =
    //[3,9,20,null,null,15,7]
    //Output
    //[[3],[20,9],[7,15]]
    //Expected
    //[[3],[20,9],[15,7]]
}
