package pattern42;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinaStream {

   PriorityQueue<Integer> min_heap;
   int k;


    public KthLargestElementinaStream(int k, int[] nums) {
        this.k=k;

        //maintain min heap of size k
        //everytime we assign something , create a min heap and kth largest element on the top
        min_heap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            min_heap.add(nums[i]);
            if(min_heap.size()>k)
            {
                min_heap.poll();
            }
        }

    }

    public int add(int val) {

        min_heap.add(val);
        if(min_heap.size()>k)
        {
            min_heap.poll();
        }

        return min_heap.peek();

    }

    //Input:
    //["KthLargest", "add", "add", "add", "add", "add"]
    //[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    //
    //Output: [null, 4, 5, 5, 8, 8]
    //
    //Explanation:
    //
    //KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    //kthLargest.add(3); // return 4
    //kthLargest.add(5); // return 5
    //kthLargest.add(10); // return 5
    //kthLargest.add(9); // return 8
    //kthLargest.add(4); // return 8
}
