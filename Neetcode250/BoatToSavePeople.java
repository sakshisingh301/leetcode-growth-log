import java.util.Arrays;

public class BoatToSavePeople {

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int start=0;
        int end=people.length-1;
        int min=0;

        //thinking: after sort = {1,2,2,3}
        //
        while(start<=end)
        {
            int sum=people[start]+people[end];
            if(sum>limit)
            {
                end--;

            }
            else {
                start++;
                end--;
            }
            min++;

        }
        return min;


    }


    public static void main(String[] args) {
        //Input: people = [3,2,2,1], limit = 3
        int [] people={3,2,2,1};
        int limit=3;
        System.out.println(numRescueBoats(people,limit));

        //people = [3,5,3,4], limit = 5
        //[5,4,3,3], limit- 5

    }
}
