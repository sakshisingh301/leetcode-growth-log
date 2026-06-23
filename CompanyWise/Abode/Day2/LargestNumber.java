package Abode.Day2;

import java.util.Arrays;

public class LargestNumber {

    //teaches us concept of comparator in java
    //(a, b)-> a-b = smallest number first--> (a).compareTo(b)
    //for number to be largest we should put the largest element at the start
    //(a,b) -> b-a = largest element first--> b.compareTo(a)
    //compare To is for strings
    public String largestNumber(int[] nums) {
        String [] strs=new String[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            strs[i]= String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a,b)->(b+a).compareTo(a+b));
        //after sorting the greatest number will be at the start
        //[0,0]
        //[0,2,0] - it cannot be a case as the greatest number will always be at the start
        if(strs[0].equals("0"))
        {
            return "0";
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(String s: strs)
        {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();



    }
    //Input: nums = [3,30,34,5,9]
    //Output: "9534330"
}
