package Pattern12;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
        {
            return result;
        }

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            List<Integer> temp=new ArrayList<>();
            int queueSize=queue.size();


            for(int i=0;i<queueSize;i++)
            {
                Node curr=queue.poll();
                if(curr.children!=null)
                {
                    queue.addAll(curr.children);
                }
                temp.add(curr.val);


            }
            result.add(temp);
        }
        return result;

    }
}
