public class NextPermutation {


    public static void nextPermutation(int[] nums) {
        if(nums.length==1) return;

        //find peak-1
        int pivot=-1;
        for(int i= nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                pivot=i;
                break;
            }
        }
        if(pivot==-1)
        {
            reverse(0, nums.length-1,nums );
            return;
        }
        //swap pivot with the smallest number possible but greater than nums[pivot]

        for(int i=nums.length-1;i>pivot;i--)
        {
            if(nums[i]>nums[pivot])
            {
                swap(i,pivot,nums);
                break;
            }
        }

        //reverse after pivot
        //2,3,5,4,0,0
        reverse(pivot+1,nums.length-1,nums);
    }

    private static void swap(int index1, int index2,int[] num)
    {
        int temp=num[index1];
        num[index1]=num[index2];
        num[index2]=temp;
    }

    private static void reverse(int left,int right,int [] num)
    {
        while(left<right)
        {
            swap(left,right,num);
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        int [] nums={2,1,5,4,3,0,0};
        nextPermutation(nums);
    }

    //[2,1,5,4,3,0,0]
}
