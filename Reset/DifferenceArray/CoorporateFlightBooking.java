package DifferenceArray;

public class CoorporateFlightBooking {

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        int [] prefix=new int[n+1];
        int [] result=new int[n];

        //mark only the effected stop
        for(int [] booking: bookings)
        {
            int first=booking[0];
            int last=booking[1];
            int seats=booking[2];
            prefix[first]=prefix[first]+seats;
            if(last<n) {
                prefix[last + 1] = -(seats);
            }
        }

        int sum=0;
        int index=0;

        for(int i=1;i< prefix.length;i++)
        {
            sum=sum+prefix[i];
            result[index]=sum;
            index++;

        }
        return result;
    }

    public static void main(String[] args) {
        int [] [] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n=5;
        System.out.println(corpFlightBookings(bookings,n));


                

    }

    //Example 1:
    //
    //Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
    //Output: [10,55,45,25,25]
    //Explanation:
    //Flight labels:        1   2   3   4   5
    //Booking 1 reserved:  10  10
    //Booking 2 reserved:      20  20
    //Booking 3 reserved:      25  25  25  25
    //Total seats:         10  55  45  25  25
    //Hence, answer = [10,55,45,25,25]
}
