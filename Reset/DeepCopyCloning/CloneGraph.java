package DeepCopyCloning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {

        //start node is given and other nodes are being traversed from start node
        //go to first node, mark it as visited and create a copy of the node
        //go to their neighbour and start traversing, if the node is not visited then create a new node
        //or else point the current node to the visited node if the neighbours are already visited

        //Modified version
        //Store original node and cloned node in the map
        // Node1---Node2
        //visit node1, since it is not cloned yet, clone and store (node1, clone1)
        //visit node2, since it is not cloned yet, clone and store(node2, clone2)
        HashMap<Node,Node> map=new HashMap<>();
        return Clone(node, map);

    }

    private Node Clone(Node node, HashMap<Node, Node> map) {
        //create a node
        Node newNode=new Node(node.val);
        map.put(node,newNode);
        //go through the neighbour
        for(Node neighbour: node.neighbors)
        {
            if(!map.containsKey(neighbour))
            {
                //create a new node
                newNode.neighbors.add(Clone(neighbour,map));
            }
            else {
                newNode.neighbors.add(map.get(neighbour));
            }
        }
        return newNode;
    }
}
