public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {

        int start=0;
        int end =0;
        double max_average=0.0;
        int sum=0;

        while(end< nums.length)
        {
            while(end-start+1<k)
            {
                sum=sum+nums[end];
                end++;
            }
            int average=sum/end-start+1;
            max_average=Math.max(max_average,average);
            sum=sum-nums[start];
            start++;
            end++;
        }
        return max_average;

    }

    //nums = [1,12,-5,-6,50,3], k = 4
}
