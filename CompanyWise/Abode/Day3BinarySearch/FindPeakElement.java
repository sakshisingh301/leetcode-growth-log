package Abode.Day3BinarySearch;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;

        int start=0;
        int end=nums.length-1;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(mid>0 && mid< nums.length-1 &&nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
            {
                return mid;
            }
            else if(mid<nums.length-1 &&nums[mid]<nums[mid+1])
            {
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return start;

    }

    //Input: nums = [1,2,1,3,5,6,4]
    //Output: 5
    //Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

    public static void main(String[] args) {
        int [] nums={1,2};
        System.out.println(findPeakElement(nums));

    }
}
