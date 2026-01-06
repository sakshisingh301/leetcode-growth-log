import java.util.HashMap;
import java.util.HashSet;

public class TwoSumIIInputArrayIsSortedRevision {

    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<numbers.length;i++)
        {
            map.put(numbers[i],i);
        }

        for(int i=0;i<numbers.length;i++)
        {
            int complement=target-numbers[i];
            if(map.containsKey(complement) )
            {
                return new int[]{i+1,map.get(complement)+1};
            }
        }
        return new int[]{};

    }




    public static void main(String[] args) {

        //numbers = [2,7,11,15], target = 9

    }
}
