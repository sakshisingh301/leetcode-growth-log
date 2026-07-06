package SlidingWindow;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {

        int start=0;
        int end= 0;
        int countOne=0;
        int maxConsecutiveOne=0;

        //count the number of 0's
        while(end<nums.length)
        {
            if(nums[end]==1)
            {
                countOne ++;

            }

            //valid
            while((end-start+1)-countOne>k)
            {
                if(nums[start]==1)
                {
                    countOne--;
                }
                start++;

            }
            maxConsecutiveOne=Math.max(maxConsecutiveOne, end-start+1);
            end++;

        }
        return maxConsecutiveOne;



    }

    public static void main(String[] args) {
        int [] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }

    //Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    //Output: 6
    //Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    //Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
}
