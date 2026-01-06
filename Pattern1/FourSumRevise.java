import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSumRevise {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i< nums.length-3;i++)
        {
            for(int j=i+1;j<nums.length-2;j++)
            {
                int curr_sum=nums[i]+nums[j];
                int curr_target=target-curr_sum;
             res.addAll(twoPointer(i,j, curr_target,nums ));

            }
        }
        return res;

    }
    //handling duplicates is remaining

    private List<List<Integer>> twoPointer(int i, int j, int currTarget, int [] nums) {
        List<List<Integer>> res=new ArrayList<>();

        HashSet<Integer> seen =new HashSet<>();
        HashSet<Integer> avoidduplicates=new HashSet<>();
        for(int x=j+1;x<nums.length;x++ )
        {
            int complement=currTarget-nums[x];
            if(seen.contains(complement))
            {
                List<Integer> quadralet = Arrays.asList(nums[i],nums[j],complement, nums[x]);
                res.add(quadralet);


            }
            seen.add(nums[x]);
            avoidduplicates.add(nums[x]);
        }
        return res;


    }


    public static void main(String[] args) {
//nums = [1,0,-1,0,-2,2], target = 0
        //{-2,-1,0,0,1,2}
        //{2,2,2,2,2}
        // target =8
    }
}
