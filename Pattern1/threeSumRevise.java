import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSumRevise {


    //
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            int curr=nums[i];
            int target=-curr;
            if(i>0 && curr==nums[i-1])
            {
                continue;
            }
            twoSum(i,res,nums,target);
        }
        return res;
    }

    private static void twoSum(int i, List<List<Integer>> res, int[] nums,int target) {
        HashSet<Integer> seen=new HashSet<>();

        for(int x=i+1;x< nums.length;x++)
        {
            int complement=target-nums[x];
            if(seen.contains(complement))
            {
                List<Integer> triplets=Arrays.asList(nums[x], complement, nums[i]);
                res.add(triplets);
                while(x+1<nums.length &&nums[x]==nums[x+1] )
                {
                    x++;
                }
            }
            seen.add(nums[x]);
        }
    }


    public static void main(String[] args) {
        int [] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        //[-4,-1,-1,0.1,2]

    }
}
