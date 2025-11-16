import java.util.HashMap;

public class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }

    private int capacity;
    Node head;
    Node tail;
    HashMap<Integer,Node> map=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }


    public int get(int key) {

        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        removeNode(node);
        addAtTheFront(node);
        return node.val;

    }

    private void addAtTheFront(Node node) {

        Node nextNode=head.next;
        node.next=nextNode;
        nextNode.prev=node;
        head.next=node;
        node.prev=head;



    }

    private void removeNode(Node node) {

        Node prevNode=node.prev;
        Node nextNode=node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;

    }

    public void put(int key, int value) {

        //if the key exists already then we will have to update the value
        if(map.containsKey(key))
        {
            //delete the node
            //add the node at the start
            Node node=map.get(key);
            node.val=value;
            removeNode(node);
            addAtTheFront(node);
            return;


        }



        if(map.size()==capacity)
        {
            // remove LRU
            Node lruNode=tail.prev;
            removeNode(lruNode);
            map.remove(lruNode.key);
        }
        Node newNode=new Node(key, value);
        map.put(key, newNode);
        addAtTheFront(newNode);


    }

    //Input
    //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    //Output
    //[null, null, null, 1, null, -1, null, -1, 3, 4]
}
