package Abode.Day1;

public class ProductofArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        //get left prefix product
        //[1,2,6,24]
        //get the right prefix product
        //[24, 24,12,4]
        int [] left=new int[nums.length];
        int [] right=new int[nums.length];

        int leftProduct=1;
        for(int i=0;i<nums.length;i++)
        {
            leftProduct=leftProduct*nums[i];
            left[i]=leftProduct;

        }

        int rightProduct=1;
        int length=nums.length-1;

        for(int i=length;i>=0;i--)
        {
            rightProduct=rightProduct*nums[i];
            right[i]=rightProduct;
        }
        //main logic
        int [] result=new int[nums.length];
        int leftPrefix=1;
        int rightPrefix=1;


        for(int i=1;i<nums.length-1;i++)
        {
         result[i]=left[i-1]*right[i+1];

        }
        result[0]=leftPrefix*right[1];
        result[nums.length-1]=rightPrefix*left[nums.length-2];
        return result;


    }

    public static void main(String[] args) {
        int [] nums={1,2,3,4};
        System.out.println(productExceptSelf(nums));


    }


    //Example 1:
    //
    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]
}
