import java.util.HashMap;

public class TwoSumA {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i< nums.length;i++)
        {
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++)
        {
            int key=target-nums[i];
            if(map.containsKey(key) && map.get(key)!=i)
            {
                return new int []{i,map.get(key)};
            }

        }
        return null;

    }

    //can we optimise it further by using one loop

    public int[] twoSum1(int[] nums, int target) {

        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int key=target-nums[i];
            if(map.containsKey(key))
            {
                return new int[]{i, map.get(key)};

            }
            map.put(nums[i],i);
        }
        return null;

    }


    public static void main(String[] args) {
        //nums = [2,7,11,15], target = 9

    }
}
