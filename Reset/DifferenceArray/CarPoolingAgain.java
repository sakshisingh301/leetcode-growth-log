package DifferenceArray;

public class CarPoolingAgain {

    public boolean carPooling(int[][] trips, int capacity) {

        //create a prefix sum for range 0 to 1001
        //start from the from_i and go till to_i for each trip and keep updating the prefixSum array with numberOfPassenger
        //but the time complexity will be n*2 so we can use the technique of difference array

        int [] passengers=new int[1001];

        for(int[]trip: trips)
        {
            int from=trip[1];
            int to=trip[2];
            int numOfPassenger=trip[0];

            passengers[from]=passengers[from]+numOfPassenger;
            if(to<1001)
            {
                passengers[to]=passengers[to]+(-1*numOfPassenger);
            }

        }

        //calculate prefixsum
        int temp=0;
        for(int i=0;i<1001;i++)
        {
            temp=temp+passengers[i];
            passengers[i]=temp;
        }

        //check if at any point if the num of passenger got exceeded

        for(int i=0;i<passengers.length;i++)
        {
            if(passengers[i]>capacity)
            {
                return false;
            }
        }
        return true;

    }
    //Input: trips = [[2,1,5],[3,3,7]], capacity = 4
    //Output: false
    //Explanation:
    //At kilometer 1, 2 passengers are picked up, so the car holds 2.
    //At kilometer 3, 3 more are picked up, so the car holds 5.
    //Since 5 > capacity = 4, the trips cannot all be completed.
}
