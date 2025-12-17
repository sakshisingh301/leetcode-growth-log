import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum =nums[0]+nums[1]+nums[2];


        for(int i=0;i<nums.length-2;i++)
        {

            closestSum =twoPointer(i,nums,target, closestSum);


        }
        return closestSum;



    }

    private static int twoPointer(int fixedPointer, int[] nums, int target, int initialSum) {

        int start=fixedPointer+1;
        int end= nums.length-1;

        while(start<end)
        {
            int sum=nums[fixedPointer]+nums[start]+nums[end];

            if(Math.abs(target-sum)< Math.abs(target-initialSum))
            {
                initialSum=sum;
            }

            if(sum<=target)
            {
                start++;

            }
            else
            {
                end--;

            }
        }
       return  initialSum;
    }

    public static void main(String[] args) {
        int []  nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));

        //-4,-1,1,2

    }
}
