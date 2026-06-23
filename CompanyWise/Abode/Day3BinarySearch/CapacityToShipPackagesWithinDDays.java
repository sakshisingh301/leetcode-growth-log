package Abode.Day3BinarySearch;

public class CapacityToShipPackagesWithinDDays {


    //naive solution: start from minweight and go till the max weight and calculate the number of days, if number of day is equal to days given, return the first weight
    //find out the min weight && max weight
    //find mid weight and calculate the number of days it take to ship from one port to another
    //if number of days is less than days provided then limit the search space to the left because we want to increase the number of days
    //if number of days is greater than days provided then limit the search space to the right
    public int shipWithinDays(int[] weights, int days) {
        int minimumCapacity=0;
        int max_weight_start=Integer.MIN_VALUE;
        for(int weight: weights)
        {
            max_weight_start=Math.max(weight,max_weight_start);
        }
        int max_weight_end=0;
        for(int weight: weights)
        {
            max_weight_end=max_weight_end+weight;
        }

        int start=max_weight_start;
        int end=max_weight_end;

        while(start<=end)
        {
            int mid=(start+end)/2;
            int noOfDaysRequired=calculateDaysToShip(weights,mid);

            if(noOfDaysRequired<=days)
            {
                end=mid-1;
                minimumCapacity=mid;

            }
            else {
                start=mid+1;
            }


        }
        return minimumCapacity;




    }

    private int calculateDaysToShip(int[] weights,int weight)
    {
        int days=1;
        int sum=0;
        for(int w: weights)
        {

            if(w+sum>weight)
            {
                days++;
                sum=0;
            }
            sum=sum+w;

        }
        return days;

    }

    //Example 1:
    //
    //Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
    //Output: 15
    //Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
    //1st day: 1, 2, 3, 4, 5
    //2nd day: 6, 7
    //3rd day: 8
    //4th day: 9
    //5th day: 10
    //
    //Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
}
