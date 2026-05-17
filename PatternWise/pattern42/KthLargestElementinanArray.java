package pattern42;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    public static int findKthLargest(int[] nums, int k) {

        //max_heap with k size

        PriorityQueue<Integer> min_heap=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++)
        {
            min_heap.add(nums[i]);
            if(min_heap.size()>k)
            {
                min_heap.poll();
            }
        }
        return min_heap.poll();



    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));

    }

    //Input: nums = [3,2,1,5,6,4], k = 2
    //Output: 5
}
