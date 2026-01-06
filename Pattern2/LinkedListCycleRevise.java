public class LinkedListCycleRevise {

    class ListNode
    {
        int val;
        ListNode next;

        public ListNode(int x)
        {
            val= x;
            next=null;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null )
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
            {
                return true;
            }
        }
        return false;

    }
}
