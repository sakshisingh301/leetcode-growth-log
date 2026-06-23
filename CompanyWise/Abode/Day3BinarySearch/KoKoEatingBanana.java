package Abode.Day3BinarySearch;

public class KoKoEatingBanana {

    public static int minEatingSpeed(int[] piles, int h) {

        //find out min and max banana coco can eat
        int start=1;
        int end=Integer.MIN_VALUE;
        int minK=0;
        for(int i=0;i<piles.length;i++)
        {
            end=Math.max(piles[i],end);
        }

        while(start<=end)
        {
            int mid=(start+end)/2;
            int hoursToCompleteThePile=0;

            for(int hour: piles)
            {
                hoursToCompleteThePile = (int)(hoursToCompleteThePile + Math.ceil((double)hour / mid));
            }

            if(hoursToCompleteThePile<=h)
            {
                minK=mid;
                end=mid-1;

            }
            else {
                start=mid+1;
            }
        }
        return minK;

    }


    public static void main(String[] args) {
       int [] piles = {3,6,7,11};
       int h = 8;
       System.out.println(minEatingSpeed(piles,h));

    }

    //Input: piles = [3,6,7,11], h = 8
    //Output: 4
}
