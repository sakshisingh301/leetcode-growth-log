package Pattern4;

public class movezeros {

    public void moveZeroes(int[] nums) {

        //i am using the same concept as remove duplicate from sorted array
        //keeping a variable k which keeps the count of non zeros numbers

        int k=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[k]=nums[i];
                k++;
            }
        }

        for(int i=k;i<nums.length;i++)
        {
            nums[i]=0;

        }

    }
    //Input: nums = [0,1,0,3,12]
}
