package designQuestion;

class LinkedListNode
{
    int key;
    LinkedListNode next;

    LinkedListNode(int key)
    {
        this.key=key;
    }
}

public class MyHashSet {

    private LinkedListNode[] buckets;
    int size=1000;

    public MyHashSet() {
        buckets= new LinkedListNode[size];

    }

    public void add(int key) {
        int index=key%size;
        //if the key does not exist
        if(buckets[index]==null)
        {
            buckets[index]=new LinkedListNode(key);
            return;
        }
        //if the key exists
        LinkedListNode curr=buckets[index];

        while(curr!=null)
        {
            //key already exists
            if(curr.key==key)
            {
               return;
            }
            if(curr.next==null)
            {
                break;
            }
            curr=curr.next;

        }
        curr.next=new LinkedListNode(key);


    }

    public void remove(int key) {
        int index=key%size;
        if(buckets[index]==null)
        {
            return;
        }
        LinkedListNode curr=buckets[index];
        LinkedListNode prev=null;

        while(curr!=null)
        {
            if(curr.key==key)
            {
                if(prev==null)
                {
                    buckets[index]=curr.next;

                }
                else {
                    prev.next=curr.next;
                }
            }
            prev=curr;
            curr=curr.next;
        }



    }

    public boolean contains(int key) {
        int index=key%size;
        LinkedListNode curr=buckets[index];
        if(curr==null) return false;

        while(curr!=null)
        {
            if(curr.key==key)
            {
                return true;
            }
            curr=curr.next;
        }
        return false;


    }
}
