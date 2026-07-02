package InplaceArrayRotationPattern4;

import java.util.Arrays;

public class Hindex {
    //Do we have atleast h paper that has been cited by atleast h times?
    public static int hIndex(int[] citations) {

        Arrays.sort(citations);


        //[0,1,3,5,6]
        for(int i=0;i<citations.length;i++)
        {
            int curr=citations[i];
           int h=citations.length-i;
           //invalid condition
            //at index=2, curr=3 && h=3, why its a breaking point
            //because before 3 there are 3 already 3 papers that are cited
            //at index=1, curr=1, How many papers are there which are cited atleast 1 times
            //at index=3 curr= 5, How many papers are there which cited at least 3 times--3,5,6
            //at index=4 curr= 6, do we have 6 papers which have been cited atleast 6 times?

            if(curr>=h)
            {
                return h;
            }


        }
        return 0;

    }

    public static void main(String[] args) {
        int []citations = {0,1,3,5,6};
        System.out.println(hIndex(citations));

    }

    //citations = [3,0,6,1,5]
    //[0,1,3,5,6]
    //h index=3;
}
