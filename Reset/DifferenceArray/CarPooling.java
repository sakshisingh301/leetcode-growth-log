package DifferenceArray;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        int [] prefix=new int[1001];

        for(int [] trip: trips)
        {
            int tripFrom=trip[1];
            int tripTo=trip[2];
            int numOfPassenger=trip[0];
            prefix[tripFrom]=prefix[tripFrom]+numOfPassenger;
            if(tripTo<prefix.length)
            {
                prefix[tripTo]=prefix[tripTo]-numOfPassenger;
            }

        }
        int sum=0;
        for(int i=1;i< prefix.length;i++)
        {
            sum=sum+prefix[i];
            if(sum>capacity)
            {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        //Example 1:
        //
        //Input: trips = [[2,1,5],[3,3,7]]capacity = 4
        //Output: false
        //Example 2:
        //
        //Input: trips = [[2,1,5],[3,3,7]], capacity = 5
        //Output: true

    }
}
