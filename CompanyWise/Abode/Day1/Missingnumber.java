package Abode.Day1;

public class Missingnumber {

    public int missingNumber(int[] nums) {

        //get actual sum and expected sum and get the difference
        int n=nums.length;
        int expectedSum=n*(n+1)/2;
        int actualSum=0;

        for(int num: nums)
        {
            actualSum=actualSum+num;
        }
        return expectedSum-actualSum;

    }

    //Input: nums = [3,0,1]
    //
    //Output: 2
    //
    //Explanation:
    //
    //n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
    // 2 is the missing number in the range since it does not appear in nums.
}
