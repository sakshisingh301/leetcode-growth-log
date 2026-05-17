package Pattern45;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {


            //sort this by start pointer
            Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
            int minimumRoom=1;
            //define minheap
            PriorityQueue<Integer> minHeap=new PriorityQueue<>();
            minHeap.add(intervals[0][1]);

            for(int i=1;i< intervals.length;i++)
            {

                //check if they are coinciding, increase the room counter
                if(!minHeap.isEmpty() &&minHeap.peek()>intervals[i][0])
                {
                    minimumRoom++;

                }
                else {
                    minHeap.poll();
                }
                minHeap.add(intervals[i][1]);



            }
            return minimumRoom;









    }
    //Input: intervals = [[0,30],[5,10],[15,20]]
    //Output: 2
}
