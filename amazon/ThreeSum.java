import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++)
        {
            if(i>0 &&nums[i]==nums[i-1])
            {
                continue;
            }
            int curr=nums[i];
            int target=-curr;
            twoSum(nums,i+1,target, i, results);

        }
        return results;



    }

    private void twoSum(int[] nums, int currNext, int target, int curr,List<List<Integer>> results) {

        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=currNext;i<nums.length;i++)
        {
            int key=target-nums[i];
            if(map.containsKey(key))
            {
                List<Integer> triplets=Arrays.asList(nums[curr], nums[i],key);
                results.add(triplets);
                while(i+1<nums.length && nums[i]==nums[i+1])
                {
                    i++;
                }


            }
            map.put(nums[i],i);

        }
    }



    public static void main(String[] args) {

        //Input: nums = [-1,0,1,2,-1,-4]--> [-4,-1,-1,0,1,2]
        //Output: [[-1,-1,2],[-1,0,1]]

    }
}
