package Abode.Day1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //minheap
        PriorityQueue<int []> min_heap=new PriorityQueue<>((a,b)-> a[1]-b[1]);
        //go through the Hashmap and put the element in minheap
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            int key=entry.getKey();
            int value=entry.getValue();
            min_heap.add(new int[]{key,value});
            if(min_heap.size()>k)
            {
                min_heap.poll();
            }
        }

        int[] res=new int[k];
        int index=k-1;

        while (!min_heap.isEmpty())
        {
            int [] element=min_heap.poll();
            res[index]=element[0];
            index--;
        }
        return res;


    }


}
//min heap and then reverse it

//Input: nums = [1,1,1,2,2,3], k = 2
//
//Output: [1,2]

//time complexity: nlog(k)