import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);
        int threeSumSmaller=0;

        for(int i=0;i< nums.length-2;i++)
        {
           threeSumSmaller=threeSumSmaller+ twoPointer(i,nums,target);

        }
        return threeSumSmaller;

    }

    private int twoPointer(int index, int[] nums, int target) {

        int start=index+1;
        int end=nums.length-1;
        int smallerSum=0;

        while(start<end)
        {
            int currentSum=nums[start]+nums[end]+nums[index];
            //if(nums[start]+nums[end]+nums[index]) is valid so nums[start+1]+nums[end]+nums[index],
            //nums[start+2]+nums[end]+nums[index], nums[start+till the end will be valid]+nums[end]+nums[index]
            //hence move forward
            if(currentSum<target)
            {
                smallerSum=smallerSum+(end-start);
                start++;

            }
            else {
                end--;
            }

        }
        return smallerSum;


    }


    //nums = [3,1,0,-2], target = 4
    //[-2,0,1,3]
    //[-2,0,1]
    //[-2,0,3]
}
