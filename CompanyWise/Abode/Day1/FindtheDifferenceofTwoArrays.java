package Abode.Day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindtheDifferenceofTwoArrays {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> setForNum1=new HashSet<>();
        HashSet<Integer> setForNum2=new HashSet<>();

        for(Integer num: nums1)
        {
            setForNum1.add(num);

        }

        for(Integer num: nums2)
        {
            setForNum2.add(num);
        }

        List<List<Integer>> result=new ArrayList<>();

        List<Integer> temp1=new ArrayList<>();
        for(Integer num: setForNum1)
        {
            if(!setForNum2.contains(num))
            {
                temp1.add(num);

            }

        }

        result.add( temp1);

        List<Integer> temp2=new ArrayList<>();
        for(Integer num: setForNum2)
        {
            if(!setForNum1.contains(num))
            {
                temp2.add(num);

            }

        }

        result.add( temp2);
        return result;


    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3};
        int [] nums2 = {2,4,6};
        System.out.println(findDifference(nums1,nums2));

    }

    //Input: nums1 = [1,2,3], nums2 = [2,4,6]
    //Output: [[1,3],[4,6]]
}
