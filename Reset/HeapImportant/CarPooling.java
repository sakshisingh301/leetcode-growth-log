package HeapImportant;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        //sort it by from and if the from is equal then sort by to (increasing order)
        Arrays.sort(trips, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            } else {
                return Integer.compare(a[1], b[1]);
            }

        });
        //minheap to store number of passenger and to
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.add(new int[]{trips[0][0], trips[0][2]});
        int totalPassenger = trips[0][0];
        if(trips[0][0]>capacity)
        {
            return false;
        }

        for(int i=1;i< trips.length;i++)
        {
            int [] curr=trips[i];
            int currStart=curr[1];
            int currEnd=curr[2];
            int currNoOfPassenger=curr[0];

           //when we are picking up the passengers from current trip, drop off the passenger who has finished
            //trip
            while(!minHeap.isEmpty() && minHeap.peek()[1]<=currStart)
            {
                int [] droppedPassenger= minHeap.poll();
                int droppedPassengerNumber=droppedPassenger[0];
                totalPassenger=totalPassenger-droppedPassengerNumber;

            }
            totalPassenger=totalPassenger+currNoOfPassenger;
            if(totalPassenger>capacity)
            {
                return false;
            }
            minHeap.add(new int[]{currNoOfPassenger, currEnd});

        }
        return true;


    }

    //Example 1:
    //
    //Input: trips = [[9,3,6],[8,1,7],[6,6,8],[8,4,9],[4,2,9]], capacity = 28
    //Output: false;
    //Example 2:
    //
    //Input: trips = [[2,1,5],[3,3,7]], capacity = 5
    //Output: true
}
