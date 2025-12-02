public class TeemoAttacking {

    // this question was easy but clean coding always help finding the solution better
    //defined overlap variable

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        //{1,2,3}
        int count=duration;
        //last should be at 3
        int last=timeSeries[0]+duration-1;

        for(int i=1;i<timeSeries.length;i++)
        {
            int curr=timeSeries[i];
            if(curr<=last)
            {
                //find overlap {1,2,3} {2,3,4}
                // 2, 3 are overlapping
                int overlap=last-curr+1;
                count=count-overlap;
            }
            count=count+duration;
            last=curr+duration-1;



        }
        return count;

    }

    public static void main(String[] args) {
        int [] timeSeries = {1,2,4};
        int duration = 3;
        System.out.println(findPoisonedDuration(timeSeries,duration));
    }

    // timeSeries = [1,2,4], duration = 3
}
