package TaskSceduling;

import java.util.*;

public class TaskSceduling {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map=new HashMap<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());


        for(char task: tasks)
        {
            map.put(task, map.getOrDefault(task,0)+1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value=entry.getValue();
            maxHeap.add(value);
        }

        int TotalTime=0;
        while(!maxHeap.isEmpty())
        {
            int time=0;
            List<Integer> remainingTask=new ArrayList<>();
            //go till you can choose a new batch of task
            while(time<n+1 && !maxHeap.isEmpty()) {
                //take out the max frequency element from the max heap
                int maxFrequency = maxHeap.poll();
                //decrease its frequency and increment its time
                maxFrequency--;
                if(maxFrequency>0)
                {
                    remainingTask.add(maxFrequency);
                }
                time++;
            }

            //once one batch is processed, put back the remaining tasks to the max heap again
            for(int i=0;i<remainingTask.size();i++)
            {
                maxHeap.add(remainingTask.get(i));
            }

            //update the time
            if(!maxHeap.isEmpty())
            {
                TotalTime=TotalTime+n+1;

            }
            else {
                TotalTime=TotalTime+time;
            }

        }
        return TotalTime;



    }

    //Example 1:
    //
    //Input: tasks = ["A","A","A","B","B","B"], n = 2
    //
    //Output: 8
    //
    //Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
    //
    //After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.
}
