package Abode.Day2;

public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {

   //

    public static long countSubarrays(int[] nums, int k) {

        //find maximum number first
        long max_num=Long.MIN_VALUE;

        for(Integer num: nums)
        {
            max_num=Math.max(num, max_num);
        }

        int start=0;
        int end=0;
        int maxCount=0;
        long noOfSubArrays=0;
        while (end<nums.length)
        {
            int curr=nums[end];
            if(curr==max_num)
            {
                maxCount++;
            }
            //count subarray when the max num is greater or equal to k
            while(maxCount>=k)
            {
                noOfSubArrays += nums.length - end;
                if(nums[start]==max_num)
                {
                    maxCount--;
                }

                start++;
            }
            end++;
        }
        return noOfSubArrays;

    }

    public static void main(String[] args) {
        int [] nums = {1,3,2,3,3};
        int k = 2;
        System.out.println(countSubarrays(nums,k));

    }

    //Input: nums = [1,3,2,3,3], k = 2
    //Output: 6
    //Explanation: The subarrays that contain the element 3 at least 2 times are:
    // [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
}
