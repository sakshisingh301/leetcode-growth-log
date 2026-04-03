import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK_ElementsA {


    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map=new HashMap<>();
        //0(n)
        for(int i=0;i< nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        // min heap(a-b)
        //since we have size k
        PriorityQueue<int []> min_heap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        //keep putting the elements into heap if size>k, remove the top element
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int key=entry.getKey();
            int count=entry.getValue();
            //adding the element is logk (it depends on the size of the heap)
            min_heap.add(new int []{key, count});
            if(min_heap.size()>k)
            {
                //removing is logk
                min_heap.poll();
            }
        }

        int [] results=new int[k];
        int i=0;

        while(k>0)
        {
            results[i]=min_heap.poll()[0];
            k--;
            i++;

        }
        return results;


    }

    //hashmap: 0(n)
    // taking m elements from hashmap and putting that into priority queue
    //insertion or poll is log(k)
    //at most there will be m insertion or poll
    //mlogk
    //again polling k elements klogk
    // 0(n) + mlog(k) + klog(k) =klogk
    public static void main(String[] args) {
        //Input: nums = [1,1,1,2,2,3], k = 2
    }
}
