package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrder {

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
        public TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;

        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

       List< List<Integer>> result=new ArrayList<>();
       if(root==null)
       {
           return result;
       }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            List<Integer> temp=new ArrayList<>();
            int size=queue.size();

            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();

                if(curr!=null)
                {
                    temp.add(curr.val);
                    if(curr.left!=null)
                    {
                        queue.add(curr.left);
                    }
                    if(curr.right!=null)
                    {
                        queue.add(curr.right);
                    }
                }
            }
            result.add(temp);
        }
        return result;

    }


    public static void main(String[] args) {

    }
}
