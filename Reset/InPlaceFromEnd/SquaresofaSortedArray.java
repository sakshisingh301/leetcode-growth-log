package InPlaceFromEnd;

public class SquaresofaSortedArray {

    public static int[] sortedSquares(int[] nums) {

        //square each element and sort it
        //use two pointer
        int start=0;
        int end=nums.length-1;
        int [] result=new int[nums.length];
        int k=nums.length-1;

        while(start<=end )
        {
            if(nums[start]*nums[start]<=nums[end]*nums[end])
            {
                result[k]=nums[end]*nums[end];
                k--;
                end--;
            }
            else if(nums[start]*nums[start]>nums[end]* nums[end])
            {
                result[k]=nums[start]*nums[start];
                k--;
                start++;

            }
        }
        return result;


    }

    public static void main(String[] args) {
        int [] nums={-4,-1,0,3,10};
        System.out.println(sortedSquares(nums));

    }
    //Input: nums = [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
}
