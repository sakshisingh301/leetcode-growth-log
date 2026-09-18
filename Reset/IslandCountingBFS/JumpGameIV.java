package IslandCountingBFS;

import java.util.*;

public class JumpGameIV {

    public int minJumps(int[] arr) {

       //store indexes in the queue
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        //number and its indexes
        HashMap<Integer, List<Integer>> valueToIndex=new HashMap<>();
        for(int i=0;i< arr.length;i++)
        {
            if(!valueToIndex.containsKey(arr[i]))
            {
                valueToIndex.put(arr[i],new ArrayList<>());

            }
            valueToIndex.get(arr[i]).add(i);
        }
        boolean[] visited=new boolean[arr.length];
        visited[0]=true;
        int minimumStep=0;


        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++) {
                int curr = queue.poll();
                if (curr == arr.length - 1) {
                    return minimumStep;
                }
                //neighbours will be i+1, i-1, arr[j] if present
                if (curr + 1 < arr.length && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.add(curr + 1);
                }
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.add(curr - 1);
                }
                //if the number exists somewhere else
                List<Integer> indexes = valueToIndex.get(arr[curr]);
                if(indexes!=null) {
                    for (int index : indexes) {
                        if (!visited[index]) {

                            visited[index] = true;
                            queue.add(index);
                        }

                    }
                    valueToIndex.remove(arr[curr]);
                }
            }
            minimumStep++;


        }
        return -1;

    }

    public static void main(String[] args) {
        //Example 1:
        //
        //Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
        //Output: 3
        //Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

    }
}
