package HeapImportant;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom3 {

    public int mostBooked(int n, int[][] meetings) {
        //sort by start time
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0],b[0]));

        //keeping track of meeting ending time, no of rooms
        //keep how many times that room is used separately
        //minheap to see which meetings are ending fist so that the present meetings can be held in that room
        PriorityQueue<int []> minHeap=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])
            {
                return Integer.compare(a[1],b[1]);
            }
            else {
                return Integer.compare(a[0],b[0]);
            }
        });
        int [] roomUsed=new int[n];
        PriorityQueue<Integer> availableRooms=new PriorityQueue<>();
        //initially all the rooms will be available
        for(int i=0;i<n ;i++)
        {
            availableRooms.add(i);
        }

        // we want to go through the meetings and assign the rooms
        for(int i=0;i<meetings.length;i++)
        {
            //if the room is empty then assign the room and update the count
            // and put the ending time and no of rooms in minheap
            int endingTime=meetings[i][1];
            int startTime=meetings[i][0];

            //if the room has become available before the meeting?
            while(!minHeap.isEmpty() && minHeap.peek()[0]<=startTime)
            {
                int room=minHeap.poll()[1];
                //this room is free now
                availableRooms.add(room);
            }

            if(!availableRooms.isEmpty())
            {

                int room=availableRooms.poll();
                roomUsed[room]++;
                minHeap.add(new int[]{endingTime, room});
            }
            else {
                //get the earlier finishing meeting
                if(!minHeap.isEmpty())
                {
                    int [] earlierMeetings=minHeap.poll();
                    int metingEndingTime=earlierMeetings[0];
                    int room=earlierMeetings[1];
                    roomUsed[room]++;
                    int newEndingTime=endingTime-startTime+metingEndingTime;
                    minHeap.add(new int[]{newEndingTime, room});
                }
            }
        }
        int result=0;

        for(int i=1;i<n;i++)
        {
            if(roomUsed[i]>roomUsed[result])
            {
                result=i;
            }
        }

        return result;

    }


    public static void main(String[] args) {
        //Example 1:
        //
        //Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
        //Output: 0
        //Explanation:
        //- At time 0, both rooms are not being used. The first meeting starts in room 0.
        //- At time 1, only room 1 is not being used. The second meeting starts in room 1.
        //- At time 2, both rooms are being used. The third meeting is delayed.
        //- At time 3, both rooms are being used. The fourth meeting is delayed.
        //- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
        //- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
        //Both rooms 0 and 1 held 2 meetings, so we return 0.

    }
}
