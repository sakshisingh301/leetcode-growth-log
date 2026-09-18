package DifferenceArray;

import java.util.ArrayList;
import java.util.List;

public class PinterestResturantAvailabilityIntervals {


    //merging code was difficult
    private List<int[]> availability(int[][] reservations, int capacity, int openingTime, int closingTime, int newPartySize)
    {
        List<int[]> result=new ArrayList<>();

        int[] availability=new int[closingTime];
        for(int [] reservation: reservations)
        {
            int start=reservation[0];
            int end=reservation[1];
            int numOfPeople=reservation[2];

            availability[start]=availability[start]+numOfPeople;
            if(end<availability.length)
            {
                availability[end]=availability[end]+(-1*numOfPeople);
            }
        }
        //calculate prefix sum
        int temp=0;
        for(int i=0;i<availability.length;i++)
        {
            temp=temp+availability[i];
            availability[i]=temp;
        }
        //calculate the available timeinterval
        int start=-1;
        for(int i=openingTime;i<closingTime;i++)
        {
            int remainingCapacity=capacity-availability[i];
            //if the remainingCapacityis valid
            if(remainingCapacity>=newPartySize)
            {
                if(start==-1)
                {
                    start=i;
                }
            }
            else
            {
                //invalid
                if(start!=-1)
                {
                    int [] res={start,i};
                    result.add(res);
                    start=-1;
                }
            }

            if(start==-1)
            {
                int [] res={start,i};
                result.add(res);

            }
        }


        return result;



    }


}
//capacity = 10
//T = 10
//
//reservations = [
//    [1, 4, 4],
//    [2, 6, 3],
//    [4, 7, 2]
//]
//
//newPartySize = 4

//Return all intervals during which the restaurant has enough remaining capacity to seat the new party.
