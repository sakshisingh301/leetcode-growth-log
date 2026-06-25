package InplaceArrayRotationPattern4;

public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        int count=1;
        int k=0;
        int i=1;
        nums[k]=nums[0];
        k++;

        while (i<nums.length)
        {

            if(nums[i]==nums[i-1])
            {
                count++;
                if(count<=2)
                {
                    nums[k]=nums[i];
                    k++;
                }

            }
            else if(nums[i]!=nums[i-1])
            {
                count=1;
                nums[k]=nums[i];
                k++;
            }
            i++;
        }
        return k;

    }
    //Input: nums = [0,0,1,1,1,1,2,3,3]
    //Output: 7, nums = [0,0,1,1,2,3,3,_,_]
    //Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
    //It does not matter what you leave beyond the returned k (hence they are underscores).

    public static void main(String[] args) {

    }
}
