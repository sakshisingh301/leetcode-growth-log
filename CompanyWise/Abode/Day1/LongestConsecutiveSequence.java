package Abode.Day1;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        //find starting point
        //set to store the numbers
        //iterate through every number and check if it can be a starting point (first number in the sequence)
        HashSet<Integer> set=new HashSet<>();
        for(Integer num: nums)
        {
            set.add(num);
        }
        int longestConsecutive=1;

        for(int i=0;i<nums.length;i++)
        {
            int current=nums[i];
            int length=1;
            if(!set.contains(current-1))
            {
                while(set.contains(current+1))
                {
                    length++;
                    current=current+1;
                }

            }
            longestConsecutive=Math.max(longestConsecutive,length);
        }

        return longestConsecutive;
    }

    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//
//
//
//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//Example 2:
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//Example 3:
//
//Input: nums = [1,0,1,2]
//Output: 3
//
