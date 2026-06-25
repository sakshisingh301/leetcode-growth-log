package InplaceArrayRotationPattern4;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int i=0;
        int k=0;

        while(i<nums.length)
        {
            if(nums[i]!=val)
            {
               nums[k]=nums[i];
               k++;
            }
            i++;
        }
        return k;

    }

    //Input: nums = [3,2,2,3], val = 3
    //Output: 2, nums = [2,2,_,_]
    //Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    //It does not matter what you leave beyond the returned k (hence they are underscores).
}
