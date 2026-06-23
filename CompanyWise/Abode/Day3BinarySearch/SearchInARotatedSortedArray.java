package Abode.Day3BinarySearch;

public class SearchInARotatedSortedArray {


    //find pivot element and decide where to move based on nums[0] && nums[end]
    public  int search(int[] nums, int target) {

        //find pivot element
        int getPivot=pivotElement(nums);
        //which means that the arrays is sorted
        if(getPivot==-1)
        {
            return binarySearch(0,nums.length-1,nums,target);
        }

        //if the pivot element is the target
        if(nums[getPivot]==target)
        {
            return getPivot;
        }
       if(nums[0]>target &&nums[getPivot-1]>nums[getPivot])
       {
           //move to the right
           return binarySearch(getPivot,nums.length-1,nums,target);
       }
       else {
           //move to the left
           return binarySearch(0,getPivot-1,nums,target);
       }

    }

    private  int binarySearch(int start,int end, int[] nums, int target)
    {
        while(start<=end)
        {
            int mid=(start+end)/2;

            if(nums[mid]==target)
            {
                return mid;

            }
            else if(nums[mid]<target)
            {
                start=mid+1;
            }
            else if(nums[mid]>target)
            {
                end=mid-1;
            }
        }
        return -1;
    }

    private  int pivotElement(int [] nums)
    {
        int start=0;
        int end=nums.length-1;


        while(start<=end)
        {
            int mid=(start+end)/2;

            //is it a pivot element?
            if(mid>0 && nums[mid]<nums[mid-1])
            {
                return mid;
            }
            else if(nums[mid]>nums[end])
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return -1;
    }

    //Example 1:
    //
    //Input: nums = [4,5,6,7,0,1,2], target = 0
    //Output: 4


    public static void main(String[] args) {
      int []  nums = {4,5,6,7,0,1,2};
      int target = 0;
     // System.out.println(search(nums,target));


    }
}
