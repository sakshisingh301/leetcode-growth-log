package HeapImportant;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public static int minMeetingRooms(int[][] intervals) {
        //sort by start time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        //Define minheap
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        //place the first meeting's end time in the min heap
        minHeap.add(intervals[0][1]);
        //number of minimum meeting room required will always be 1
        int minimumMeetingRoom=1;

        for(int i=1;i< intervals.length;i++)
        {
            int [] curr=intervals[i];
            int currStart=curr[0];
            int currEnd=curr[1];
            //if the earliest meaning is finished? if not then we need another room to continue the current meeting
            if(!minHeap.isEmpty() &&minHeap.peek()>currStart)
            {
                minimumMeetingRoom++;
            }
            else {
                minHeap.add(currEnd);

            }

        }
        return minimumMeetingRoom;


    }

    public static void main(String[] args) {
        int[][] intervals = {{9,10},{4,9},{4,17}};
        System.out.println(minMeetingRooms(intervals));


    }
}
