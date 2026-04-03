public class RemoveNthNodeFromEndofList {

 class ListNode
    {
        int val;
        ListNode next;

        ListNode(){

        }

        ListNode(int val)
        {
            this.val=val;
        }

        ListNode(int val, ListNode next)
        {
            this.val=val;
            this.next=next;

        }


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

     ListNode dummy=new ListNode(0);
     dummy.next=head;

     int length=0;
     ListNode curr=head;

     while(curr!=null )
     {
         curr=curr.next;
         length++;

     }
     int target=length-n;

     curr=dummy;

     while(target>0)
     {
         curr=curr.next;
         target--;
     }
     curr.next=curr.next.next;

     return dummy.next;

    }

    //dummy-->1-->2-->3-->4-->5
    //n=2;
}
