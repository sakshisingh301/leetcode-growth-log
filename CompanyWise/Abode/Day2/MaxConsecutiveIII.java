package Abode.Day2;

public class MaxConsecutiveIII {

    public static int longestOnes(int[] nums, int k) {

        int countOne=0;
        int start=0;
        int end=0;
        int longestOnes=0;

        while(end< nums.length)
        {
            int length=0;

            if(nums[end]==1)
            {
                countOne++;
            }
            //invalid
            while((end-start+1)-countOne>k)
            {
                if(nums[start]==1)
                {
                    countOne--;
                }
                start++;

            }
            length=end-start+1;
            end++;
            longestOnes=Math.max(longestOnes,length);
        }
        return longestOnes;

    }

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums,k));

        //Example 2:
        //
        //Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
        //Output: 10
        //Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
        //Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

    }
}
