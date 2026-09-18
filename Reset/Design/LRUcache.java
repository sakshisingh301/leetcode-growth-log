package Design;
import java.util.HashMap;
//HashMap + Doublylinkedlist (defined prev)
public class LRUcache {

    class Node
    {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value)
        {
            this.key=key;
            this.value=value;
        }

    }

    HashMap<Integer, Node> map=new HashMap<>();
    Node head;
    Node tail;
    private int capacity;


    public LRUcache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        tail.next=null;

    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            //get value
            Node node=map.get(key);

            //remove that node
            removeNode(node);
            //insert that node at the front for recently used cache
            addAtTheBack(node);
            return node.value;
        }
        return -1;
    }

    private void removeNode(Node node)
    {

        //store prev node
        Node prevNode=node.prev;
        Node nextNode=node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;

    }

    private void addAtTheBack(Node node)
    {
        Node lastNode=tail.prev;
        lastNode.next=node;
        node.prev=lastNode;
        node.next=tail;
        tail.prev=node;


    }

    public void put(int key, int value) {

        if(map.containsKey(key))
        {
            //go to that node and replace the node's value with the new value
            //get the node
            Node oldNode=map.get(key);
            oldNode.value=value;
            //delete that node and since we updated the node so it will become least recently used
            removeNode(oldNode);
            //add the node at the front
            addAtTheBack(oldNode);
            return;
        }
        if(map.size()==capacity)
        {
            //evict the least recently value, evict the front
            //remove the head.next and make head.next.next as new head
           Node lruNode=head.next;
           removeNode(lruNode);
           map.remove(lruNode.key);

        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addAtTheBack(newNode);

    }
}
