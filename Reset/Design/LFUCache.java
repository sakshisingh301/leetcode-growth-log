//package Design;
//
//import java.util.HashMap;
//
//public class LFUCache {
//
//    //maintain the frequency counter in a linkedlist which keeps track of how many times that key has been used
//    class Node
//    {
//        int key;
//        int value;
//        Node prev;
//        Node next;
//        int frequency;
//
//        public Node(int key, int value, int frequency)
//        {
//            this.key=key;
//            this.value=value;
//            this.frequency=frequency;
//        }
//    }
//
//    class DoublyLinkedList
//    {
//        Node head;
//        Node tail;
//        int size;
//
//        public DoublyLinkedList()
//        {
//            head=new Node(-1,-1,-1);
//            tail=new Node(-1,-1,-1);
//            head.next=tail;
//            tail.prev=head;
//            size=0;
//        }
//
//    }
//
//    //Maintain the list like this
//    //frequency1--> linkedlist1
//    //frequency2--> linkedlist2
//    HashMap<Integer, DoublyLinkedList> getNodeByFrequency;
//
//    HashMap<Integer, Node> getNodeByKey;
//
//    private int capacity;
//
//    public LFUCache(int capacity) {
//        getNodeByFrequency=new HashMap<>();
//        getNodeByKey=new HashMap<>();
//        this.capacity=capacity;
//
//
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//        //if the key is present then create a new entry in both the hashmaps
//        if(!getNodeByKey.containsKey(key)) {
//
//            Node node = new Node(key, value, 1);
//            getNodeByKey.put(key, node);
//            DoublyLinkedList list = getNodeByFrequency.get(key);
//            if (list == null) {
//                //create a new DoublyLinkedList
//                DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//                getNodeByFrequency.put(key, doublyLinkedList);
//            }
//           shiftToThefront()
//        }
//
//    }
//}
