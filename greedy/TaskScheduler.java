import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        //get the most frequent task and start diving the task and put remaining task back in the max_heap

        int [] frequencyChar= new int[26];
        for(int i=0;i< tasks.length;i++)
        {
            frequencyChar[tasks[i]-'A']++;
        }

        PriorityQueue<Integer> max_heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++)
        {
            if(frequencyChar[i]!=0)
            {
                max_heap.add(frequencyChar[i]);
            }
        }

        int window=n+1;

        int total_time=0;

        while(!max_heap.isEmpty())
        {
            int time=0;
            List<Integer> remaining_task =new ArrayList<>();
            for(int i=0;i<window;i++)
            {
                if(!max_heap.isEmpty())
                {
                    int mostFrequentTask=max_heap.poll();
                    mostFrequentTask--;
                    if(mostFrequentTask>0)
                    {
                        remaining_task.add(mostFrequentTask);
                    }
                    time++;
                }

            }

            for(int i=0;i<remaining_task.size();i++)
            {
                max_heap.add(remaining_task.get(i));
            }
            //heap will be empty when there are no task left
            if(max_heap.isEmpty())
            {
                total_time=total_time+time;
            }
            else {
                total_time=total_time+window;
            }


        }
        return total_time;




    }



    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        //"A","A","A","B","B","B"
        int n = 2;
        System.out.println(leastInterval(tasks,n));

    }
}
