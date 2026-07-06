package SlidingWindow;

import java.util.PriorityQueue;

public class MaximumWindowSliding {

    public int[] maxSlidingWindow(int[] nums, int k) {

        //put the element && index in priority queue
        //put the first k element in the max heap, result[0]= max_heap().peek()
        //Discard the old element in the queue, if(max.peek() is not within my window limit, then discard the old element
        //nums = [100, 1, 2, 3, 4, 5]
        //k = 3
        //after first window,max_heap().peek()= 100 then as we move to new window, the index of max heap =0 is out of
        //my current window range[1,3] so discard 100
        //tc: nlogn
        PriorityQueue<int []> max_heap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int [] result=new int[nums.length-k+1];

        //first window
        for(int i=0;i<k;i++)
        {
            max_heap.add(new int []{nums[i],i});
        }
       //update first max in the result
        result[0]=max_heap.peek()[0];
        int resultIndex=1;

        int start=1;
        int end=k;
        while(end< nums.length)
        {
            max_heap.add(new int[]{nums[end], end});
            //discard old elements
            while(!max_heap.isEmpty() && max_heap.peek()[1]<start)
            {
                max_heap.poll();
            }
            result[resultIndex]=max_heap.peek()[0];
            resultIndex++;
            end++;
            start++;
        }
        return result;


    }

    //Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    //Output: [3,3,5,5,6,7]
    //Explanation:
    //Window position                Max
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
}
