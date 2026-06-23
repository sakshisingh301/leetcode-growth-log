package Abode.Day5DFS.BFS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        int minimumRoom=1;
        PriorityQueue<Integer> min_heap=new PriorityQueue<>();
        //adding the end
        min_heap.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++)
        {
            int currEnd=intervals[i][1];

            if(!min_heap.isEmpty() && min_heap.peek()>currEnd)
            {
                minimumRoom++;
            }
            else {
                min_heap.add(currEnd);
            }
        }
        return minimumRoom;



    }

    //Example 1:
    //
    //Input: intervals = [[0,30],[5,10],[15,20]]
    //Output: 2
}
