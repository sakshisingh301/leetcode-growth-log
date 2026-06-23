package Abode.Day3BinarySearch;

public class MinimumNumberofDaystoMakemBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        //if number of flowers needed to make bouquet is more than the flowers then we cannot make a bouquet. no matter what

        if(m*k>bloomDay.length)
        {
            return -1;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int minDay=0;

        for(int day:bloomDay)
        {
            min=Math.min(min,day);
            max=Math.max(max,day);
        }

        int start=min;
        int end=max;

        while(start<=end)
        {
            int mid=(start+end)/2;
            boolean shouldMakeBouquet= canBouquetBeMade(bloomDay,m,k,mid);
            if(shouldMakeBouquet)
            {
                end=mid-1;
                minDay=mid;
            }
            else {
                start=mid+1;
            }

        }
        return minDay;

    }

    private boolean canBouquetBeMade(int[] bloomDay, int m, int k, int dayChosen) {
        int noOfFlowerInABouquet=0;
        int noOfBouquet=0;
        int index=0;

        while (index<bloomDay.length)
        {
            if(bloomDay[index]<=dayChosen) {
                noOfFlowerInABouquet++;
                if(noOfFlowerInABouquet==k)
                {
                    noOfBouquet++;
                    noOfFlowerInABouquet=0;
                }

            }
            else {
                noOfFlowerInABouquet=0;
            }
            index++;

        }

        return noOfBouquet>=m;


    }

    //Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
    //Output: 3
}
