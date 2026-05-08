package designQuestion;

class Node
{
    int key;
    int value;
    Node next;

    Node(int key, int value)
    {
        this.key=key;
        this.value=value;

    }
}

//we have buckets in the hashmap and we put keys and value as a linkedlist
//how do we find which bucket to put ? take key and (key % size) ==index
public class MyHashMapWithLinkedlist {




    private Node[] buckets;
    int size=1000; //1000 buckets

    public MyHashMapWithLinkedlist(){
        buckets=new Node[size];

    }

    private void put(int key, int value)
    {
        //find the index
        int index=key%size;

        //check if something is there on that index already if not then
        // create a node and put a key and value

        if(buckets[index]==null)
        {
            buckets[index]=new Node(key,value);
            return;
        }
        else
        {
            Node curr=buckets[index];
            //there might be multiple nodes
            //go through the node and put the node at the last
            while(curr!=null)
            {
                //if the key already exists, replace it
                if(curr.key==key)
                {
                    curr.value=value;
                    return;
                }
                if(curr.next==null)
                {
                    break;
                }

                curr=curr.next;
            }
            curr.next=new Node(key, value);
        }

    }

    private int get(int key)
    {
        //get the index
        int index=key%size;
        if(buckets[index]!=null)
        {
            Node curr=buckets[index];
            while(curr!=null)
            {
                if(curr.key==key)
                {
                    return curr.value;
                }
                curr=curr.next;
            }
        }
        return -1;
    }

    private void remove(int key)
    {
        int index=key% size;
        if(buckets[index]==null)
        {
            return;
        }
        Node curr=buckets[index];
        Node prev=null;

        while(curr!=null)
        {
            if(curr.key==key)
            {
                //if it is first node
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
    //One of the follow-ups for this question is how to make it a concurrent hashmap. Using one lock will serialize all the operations which leads to a very low efficiency. Based on the assumption that the number of read operation will be much more than write operation, my idea is to have separate read and write lock. Any other ideas?
}

//You can make it non-easy if you decide to implement "rehash" optimization, where you increase the amount of buckets and recalculate the hashcode for every stored key.
//You can also improve the execution time by changing the initial size of your buckets array. Based on my submissions - the more, the better. Tests probably use a lot of insertions
