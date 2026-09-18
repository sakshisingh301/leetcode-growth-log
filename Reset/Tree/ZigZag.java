package Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZag {

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
        public TreeNode(int val,TreeNode left, TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;

        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;

        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            level++;

            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();
                if(curr!=null) {
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
            if(level%2==0)
            {
                temp.reversed();
                result.add(temp);
            }
            else
            {
                result.add(temp);
            }

        }
        return result;

    }
}
