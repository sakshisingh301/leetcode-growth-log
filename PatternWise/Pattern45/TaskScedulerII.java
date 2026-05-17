package Pattern45;

import java.util.HashMap;

public class TaskScedulerII {

    public long taskSchedulerII(int[] tasks, int space) {

        HashMap<Integer, Integer> map=new HashMap<>();
        int minimumDays=0;

        int i=0;
        while (i<tasks.length)
        {
            int currentTask=tasks[i];
            minimumDays++;
            if(!map.containsKey(currentTask))
            {
                map.put(currentTask,minimumDays+space+1 );
                i++;
            }
            else {
                //4
               int nextAllowedDayForTheTask=map.get(currentTask);
               //we cannot pick up that task
               if(minimumDays<nextAllowedDayForTheTask)
               {
                   minimumDays=nextAllowedDayForTheTask;

               }
               map.put(currentTask,minimumDays+space+1);
               i++;


            }


        }
        return minimumDays;

    }

    //Input: tasks = [1,2,1,2,3,1], space = 3
    //Output: 9
    //Explanation:
    //One way to complete all tasks in 9 days is as follows:
    //Day 1: Complete the 0th task.
    //Day 2: Complete the 1st task.
    //Day 3: Take a break.
    //Day 4: Take a break.
    //Day 5: Complete the 2nd task.
    //Day 6: Complete the 3rd task.
    //Day 7: Take a break.
    //Day 8: Complete the 4th task.
    //Day 9: Complete the 5th task.
    //It can be shown that the tasks cannot be completed in less than 9 days.
}
