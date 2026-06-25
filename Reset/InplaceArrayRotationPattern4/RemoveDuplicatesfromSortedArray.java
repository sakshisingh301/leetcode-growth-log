package InplaceArrayRotationPattern4;

public class RemoveDuplicatesfromSortedArray {


    public int removeDuplicates(int[] nums) {

        //Similar to Remove element
        int i=1;
        int k=0;
        nums[k]=nums[0];
        k++;

        while(i< nums.length)
        {
            if(nums[i]!=nums[i-1])
            {
                nums[k]=nums[i];
                k++;

            }
            i++;
        }
        return k;


    }
}

//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
