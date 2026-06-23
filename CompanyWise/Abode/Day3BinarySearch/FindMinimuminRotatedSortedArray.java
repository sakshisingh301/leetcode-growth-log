package Abode.Day3BinarySearch;

public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {

        int start=0;
        int end=nums.length-1;

        while (start<=end)
        {
            int mid=(start+end)/2;

            //is it pivot?
            if(mid>0 &&nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            //move left
            else if(nums[mid]>nums[end])
            {
                start=mid+1;

            }
            else {
                end=mid-1;
            }
        }
        return -1;

    }

    //Input: nums = [3,4,5,1,2]
    //Output: 1
    //Explanation: The original array was [1,2,3,4,5] rotated 3 times.
}
