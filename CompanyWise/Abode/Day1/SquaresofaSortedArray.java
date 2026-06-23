package Abode.Day1;

public class SquaresofaSortedArray {

    public int[] sortedSquares(int[] nums) {

        int [] result=new int[nums.length];
        int start=0;
        int end=nums.length-1;
        int index=nums.length-1;

        while (start<end)
        {
            if(nums[start]*nums[start]<=nums[end]* nums[end])
            {
                result[index]=nums[end]*nums[end];
                end--;
            }
            else {
                result[index]=nums[start]*nums[start];
                start++;


            }
            index--;

        }
        return result;

    }


    //Example 1:
    //
    //Input: nums = [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
    //Explanation: After squaring, the array becomes [16,1,0,9,100].
    //After sorting, it becomes [0,1,9,16,100].
}
