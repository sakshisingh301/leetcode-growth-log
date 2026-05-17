//package PrefixSum;
//
//import java.util.HashMap;
//
//public class SubarraySumEqualsK {
//
//    public int subarraySum(int[] nums, int k) {
//
//        HashMap<Integer,Integer> map=new HashMap<>();
//        map.put(0,1);
//        int prefixSum=0;
//        int count=0;
//
//        for(int i=0;i<nums.length;i++)
//        {
//            prefixSum=prefixSum+nums[i];
//
//
//            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
//
//
//
//        }
//
//    }
//
//
//
//    public static void main(String[] args) {
//        int [] nums={3,4,7,2,-3,1,4,2};
//        int k=7;
//
//    }
//}
