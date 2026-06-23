package Abode.Day2;

public class NumberofSubarrayswithBoundedMaximum {
    //idea: int [] nums = {2,9,2,5,6};
    //int  left = 2, right = 8;
    //I thought lets use sliding window, find the valid window
    //valid window= { all the elements are lesser than the right}
    //go through the array and find the valid window
    // 2 is lesser than 8, move on
    //now we come to 9 and its greater than 8 so here now the array breaks
    //[2]   9   [2,5,6]
    //calculate how many subarrays we can make
    //What if we have [1,1,2], no of subarrays=6  [1] [1] [2] [1,2] [1,1] [1,1,2]
    //but [1] [1] [1,1] are invalid because we need to find one number equal or greater than 2
    //hence we calculate subarrays lesser than left-1 and right and (right-(left-1))

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int countSubArraysAll=countSubArray(nums, right);
        int countSubArraysToTheLeft=countSubArray(nums,left-1);
        return countSubArraysAll-countSubArraysToTheLeft;

    }

    private int countSubArray(int[] nums, int bound)
    {
        int start=0;
        int end=0;
        int noOfSubarrays=0;

        while(end<nums.length)
        {
            int curr=nums[end];
            if(curr>bound)
            {
                int window=end-start;
                noOfSubarrays=noOfSubarrays+window*(window+1)/2;
                start=end+1;
            }
            end++;
        }
        int window=end-start;
        noOfSubarrays=noOfSubarrays+window*(window+1)/2;
        return noOfSubarrays;

    }

    public static void main(String[] args) {
        int [] nums = {2,9,2,5,6};
        int  left = 2, right = 8;
   //     System.out.println(numSubarrayBoundedMax(nums,left,right));


    }

    //Example 1:
    //
    //Input: nums = [2,1,4,3], left = 2, right = 3
    //Output: 3
    //Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
    //Example 2:
    //
    //Input: nums = [2,9,2,5,6], left = 2, right = 8
    //Output: 7
    //[1,1,2]
}
