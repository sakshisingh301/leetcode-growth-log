import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> min_heap=new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;


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
}

//nlogk+nlogk=nlogk

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */