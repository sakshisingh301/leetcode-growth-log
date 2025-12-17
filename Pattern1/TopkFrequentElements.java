import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopkFrequentElements {
     //with max_heap the time complexity is nlogn , we can reduce it by using minheap with window
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> max_heap=new PriorityQueue<>((a1,a2)->a2[1]-a1[1]);
        HashMap<Integer,Integer> map=new HashMap<>();
       // put element and their count in a hashmap
        for(int i=0;i< nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int key=entry.getKey();
            int val=entry.getValue();

            max_heap.add(new int [] {key, val});
        }
        int [] result=new int[k];
        int index=0;

        while(k!=0 && !max_heap.isEmpty())
        {

            result[index]=max_heap.poll()[0];
            index++;
            k--;

        }
        return result;


    }
     //time to create hashmap 0(n)  && time to create min heap of size k (adding element and then removing if the size becomes more than
    //k) --> if hashmap size is u then ulogk + popping element from minheap to array log[k)
    //O(n) + ulogk + logk=nlogk
    public int [] minHeapWay(int [] nums, int k)
    {
        PriorityQueue<int [] > min_heap=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.getOrDefault(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            int key= entry.getKey();
            int val=entry.getValue();

            min_heap.add(new int [] {key, val});
            if(min_heap.size()>k)
            {
                min_heap.remove();
            }
        }
        int index=0;
        int [] result=new int[k];

        while(!min_heap.isEmpty())
        {
            result[index]=min_heap.poll()[0];
            index++;
        }
        return result;

    }




    public static void main(String[] args) {
// nums = [1,2,1,2,1,2,3,1,3,2], k = 2
    }
}
