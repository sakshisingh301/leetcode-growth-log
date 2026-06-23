package Abode.Day3BinarySearch;

public class SingleElementinaSortedArray {


    public int singleNonDuplicate(int[] nums) {

        //so here find the mid, check if its the target which means check if its a single number
        //if yes then simply return nums[mid]==nums[mid-1] or nums[mid]==nums[mid+1]
        //otherwise decide where to move ?
        //[1,1,2,3,3,4,4,8,8]
        //mid= 4 so nums[mid] is not a single number
        //where to move
        //skip the other pair -->
        //left size window =3 && right side window =4
        //you will likely to find single number in your left side because the its odd
        int start=0;
        int end=nums.length-1;

        if(nums.length==1)
        {
            return nums[0];
        }

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(mid==0)
            {
                if(nums[mid]!=nums[mid+1])
                {
                    return nums[mid];
                }
            }

            if(mid== nums.length-1)
            {
                if(nums[mid]!=nums[mid-1])
                {
                    return nums[mid];
                }
            }
            //find if it is a target
            if(nums[mid-1]!=nums[mid] && nums[mid+1]!=nums[mid])
            {
                return nums[mid];
            }

            //where to move
            //calculate left side
            int leftSide= 0;
            if(nums[mid-1]==nums[mid])
            {
                leftSide=mid-1;
            }
            else {
                leftSide=mid;
            }

            if(leftSide%2!=0)
            {
                end=mid-1;
            }
            else {
                start=mid+1;
            }


        }
        return nums[start];


    }
    //Example 1:
    //
    //Input: nums = [1,1,2,3,3,4,4,8,8]
    //Output: 2
    //Example 2:
    //
    //Input: nums = [3,3,7,7,10,11,11]
    //Output: 10
}
