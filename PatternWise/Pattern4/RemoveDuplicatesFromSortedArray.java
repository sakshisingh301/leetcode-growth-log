package Pattern4;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        //we care about the relative order and we discard the non unique numbers
        //We are diving the array into two parts [UNIQUE PART+UNKNOWN PART]
        //we will have a variable which will take care of unique element (k)
        //the last pointer of the k will be at the unique part so that we can discard the unknown part

        int k=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[k-1])
            {
                nums[k]=nums[i];
                k++;

            }

        }
        return k;

    }
    //Input: nums = [1,1,2]
    //[1,2,3]
}
