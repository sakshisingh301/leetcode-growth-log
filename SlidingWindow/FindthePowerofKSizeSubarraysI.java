//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class FindthePowerofKSizeSubarraysI {
//
//
//
//    public static int[] resultsArray(int[] nums, int k) {
//
//        int consecutive=1;
//        int n= nums.length;
//        int left=0;
//        int [] result=new int[n-k+1];
//        int i=0;
//
//        for(int right=1;right<nums.length;right++)
//        {
//            if(nums[right]>nums[right-1] && nums[right]-nums[right-1]==1)
//            {
//                consecutive++;
//
//            }
//            if(right-left+1==k)
//            {
//                if(consecutive==k)
//                {
//                    result[i]=nums[right];
//                }
//                else {
//                    result[i]=-1;
//                }
//                i++;
//                if(nums[left]<nums[left+1] && nums[left+1]-nums[left]==1)
//                {
//                    consecutive--;
//                }
//                left++;
//
//            }
//        }
//        return result;
//
//
//
//    }
//
//    public static int[] resultsArrays(int[] nums, int k) {
//
//        //Input: nums = [1,2,3,4,3,2,5], k = 3
//        int consecutive=1;
//        int start=0;
//        int end=1;
//        int [] res=new int[nums.length-k+1];
//        Arrays.fill(res, -1);
//        int index=0;
//
//        while(end<nums.length)
//        {
//            while(end-start+1<k)
//            {
//                if(nums[end]>nums[start])
//                {
//                    consecutive++;
//                }
//                end++;
//
//            }
//            if(consecutive==k)
//            {
//                res[index]=k;
//            }
//
//            consecutive--;
//            start++;
//
//            //shift the window
//
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        int [] nums = {1};
//        int k = 1;
//        System.out.println(resultsArray(nums,k));
//
//    }
//}