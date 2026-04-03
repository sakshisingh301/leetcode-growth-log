

public class OddEvenLinkedList {

       class ListNode {
     int val;
     ListNode next;
    ListNode() {}
   ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode oddEvenList(ListNode head) {
           if(head==null)
               return null;
           if(head.next==null)
               return head;

           ListNode oddStart=null;
           ListNode oddEnd=null;
           ListNode evenStart=null;
           ListNode evenEnd=null;
           ListNode curr=head;
           int count=0;
           while (curr!=null)
           {
               count++;
               if(count%2!=0)
               {
                   if(oddStart==null)
                   {
                       oddStart=curr;
                       oddEnd=curr;
                   }
                   else {
                       oddEnd.next=curr;
                       oddEnd=oddEnd.next;
                   }

               }
               else
               {
                 if(evenStart==null)
                 {
                     evenStart=curr;
                     evenEnd=curr;
                 }
                 else {
                     evenEnd.next=curr;
                     evenEnd=evenEnd.next;
                 }
               }

               curr=curr.next;

           }
           oddEnd.next=evenStart;
           evenEnd.next=null;
           return head;


    }
    public static void main(String[] args) {

    }
}
