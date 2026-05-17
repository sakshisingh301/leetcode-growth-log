package Pattern12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        left=null;
        right=null;
        this.val=val;
    }
}

public class levelOrderBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int queueSize= queue.size();
            ArrayList<Integer> temp=new ArrayList<>();

            for(int i=0;i<queueSize;i++)
            {
                TreeNode curr=queue.poll();
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
            result.add(temp);
        }
        return result;

    }
}
