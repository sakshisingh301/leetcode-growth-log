package IslandCountingBFS;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {

    public int jump(int[] nums) {

        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        boolean[] visited=new boolean[nums.length];
        visited[0]=true;
        int jump=0;

        while(!queue.isEmpty())
        {
            //1
           int size=queue.size();
           for(int i=0;i<size;i++)
           {
               //index
               int index=queue.poll();
               if(index==nums.length-1)
               {
                   return jump;
               }
               int limit=Math.min(i+nums[index],nums.length-1);
               for(int j=index+1;j<=limit;j++)
               {
                   if(!visited[j])
                   {
                       visited[j]=true;
                       queue.add(j);
                   }
               }

           }
           jump++;



        }
        return jump;

    }

    //Input: nums = [2,3,1,1,4]
    //Output: 2
    //Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    //Example 2:
    //
    //Input: nums = [2,3,0,1,4]
    //Output: 2
}
