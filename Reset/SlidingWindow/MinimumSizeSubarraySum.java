package SlidingWindow;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {


        int start=0;
        int end=0;
        int sum=0;
        int minLength=Integer.MAX_VALUE;
        while(end<nums.length)
        {
            sum=sum+nums[end];
            while (sum>=target) {

                minLength = Math.min(minLength, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;


        }
        if(minLength==Integer.MAX_VALUE)
        {
            return 0;
        }
        return minLength;

    }

    public static void main(String[] args) {
        int target=7;
        int [] nums={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }
    //Input: target = 7, nums = [2,3,1,2,4,3]
    //Output: 2
    //Explanation: The subarray [4,3] has the minimal length under the problem constraint.
}
