package Pattern45;

import java.util.*;

public class TaskSchedular {

    public int leastInterval(char[] tasks, int n) {

        //we want to finish off the task with highest frequency first
        //we will create maxheap based on the count
        int[] frequencyForTasks=new int[26];
        for(int i=0;i< tasks.length;i++)
        {
            frequencyForTasks[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<26;i++)
        {
            if(frequencyForTasks[i]!=0)
            {
                maxHeap.add(frequencyForTasks[i]);
            }
        }
        int total_time=0;
        while(!maxHeap.isEmpty())
        {
            int time=0;
            //define window
            int window=n+1;
           ArrayList<Integer> remaining_task=new ArrayList<>();
                for (int i = 0; i < window; i++) {

                    if(!maxHeap.isEmpty()) {
                        int mostFrequentTask = maxHeap.poll();
                        mostFrequentTask--;
                        if(mostFrequentTask>0)
                        {
                            remaining_task.add(mostFrequentTask);
                        }

                        time++;
                    }


                }

            for(int i=0;i<remaining_task.size();i++ )
            {
                maxHeap.add(remaining_task.get(i));
            }

                if(maxHeap.isEmpty())
                {
                    total_time=total_time+time;
                }
                else {
                    total_time=total_time+window;
                }

        }
        return total_time;


    }

    //Input: tasks = ["A","A","A","B","B","B"], n = 2
    //
    //Output: 8
    //
    //Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
    //
    //After completing task A, you must wait two intervals before doing A again.
    // The same applies to task B. In the 3rd interval, neither A nor B can be done,
    // so you idle. By the 4th interval, you can do A again as 2 intervals have passed.
}
