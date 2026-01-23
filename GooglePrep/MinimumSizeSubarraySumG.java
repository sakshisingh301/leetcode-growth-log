public class MinimumSizeSubarraySumG {

    public static int minSubArrayLen(int target, int[] nums) {

        int start=0;
        int end=0;
        int sum=0;
        int minLength=Integer.MAX_VALUE;

        while (end<nums.length)
        {
             sum=sum+nums[end];
             if(sum<target)
             {
                 end++;
             }
             else
             {
                 while(sum>=target) {
                     minLength = Math.min(end-start+1, minLength);
                     sum = sum - nums[start];
                     start++;
                 }
                 end++;

             }
        }
        return minLength==2147483647?0:minLength;

    }

    public static void main(String[] args) {
        int target = 7;
        int [] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));

    }
}
