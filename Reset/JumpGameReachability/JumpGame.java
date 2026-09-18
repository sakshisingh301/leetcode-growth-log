package JumpGameReachability;

public class JumpGame {


    public static boolean canJump(int[] nums) {

        int farthest=0;
        if(nums.length==1)
        {
            return true;
        }

        for(int i=0;i< nums.length-1;i++ )
        {
            //
            if (i > farthest) {
                return false;
            }
            int next=i+nums[i];

            farthest=Math.max(next, farthest);
            if(farthest>=nums.length-1)
            {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
      int []  nums = {1,0,1,0};
      System.out.println(canJump(nums));


    }

    //Example 1:
    //
    //Input: nums = [3,2,1,0,4]
    //Output: false
    //Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
}
