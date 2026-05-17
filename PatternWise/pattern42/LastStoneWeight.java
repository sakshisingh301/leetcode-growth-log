package pattern42;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        //max heap because we want heaviest stone on the top
        PriorityQueue<Integer> max_heap =new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<stones.length;i++)
        {
            max_heap.add(stones[i]);
        }

        while (max_heap.size()>1)
        {
            if(max_heap.size()>=2)
            {
                int first=max_heap.poll();
                int second=max_heap.poll();
                int diff=Math.abs(first-second);
                if(diff>=1)
                {
                    max_heap.add(diff);
                }
            }
        }
        if(max_heap.isEmpty())
        {
            return 0;
            }
        return max_heap.poll();


    }

    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};

    }
    //stones = [2,7,4,1,8,1]
}
