package Pattern1;

import java.util.Arrays;

public class BoatToSavepeople {

    public int numRescueBoats(int[] people, int limit) {

        int start=0;
        int end= people.length-1;
        int noOfBoat=0;
        Arrays.sort(people);

        while(start<end )
        {

            if(people[start]+people[end]>limit)
            {
               end--;
            }
            else if(people[start]+people[end]<=limit) {
                start++;
                end--;
            }
            noOfBoat++;

        }
        return noOfBoat;

    }

    //Input: people = [3,5,3,4], limit = 5
    //Output: 4
}
