package IslandCountingBFS;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {

        //put the start index in the queue
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        boolean[] visited=new boolean[arr.length];
        visited[start]=true;

        while(!queue.isEmpty())
        {
            int index=queue.poll();
            if(arr[index]==0)
            {
                return true;
            }
            int forward=index+arr[index];
            int backward=index-arr[index];
            if(forward<arr.length && !visited[forward])
            {
                queue.add(forward);
                visited[forward]=true;
            }
            if(backward>=0 && !visited[backward])
            {
                queue.add(backward);
                visited[backward]=true;
            }
        }
        return false;

    }

    //Example 1:
    //
    //Input: arr = [4,2,3,0,3,1,2], start = 5
    //Output: true
    //Explanation:
    //All possible ways to reach at index 3 with value 0 are:
    //index 5 -> index 4 -> index 1 -> index 3
    //index 5 -> index 6 -> index 4 -> index 1 -> index 3
}
