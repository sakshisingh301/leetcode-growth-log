package pattern42;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class kClosestToTheOrigin {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int []> max_heap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        ArrayList<int []>  res=new ArrayList<>();
        for(int [] point: points)
        {
            int x=point[0];
            int y=point[1];
            int d= x*x + y*y;
            max_heap.add(new int[]{d,x,y});
            if(max_heap.size()>k)
            {
                max_heap.poll();
            }

        }
        while (max_heap.size()>0)
        {
            int [] point=max_heap.poll();
            res.add(new int[]{point[1],point[2]});


        }
        return res.toArray(new int[res.size()][]);


    }

    public static void main(String[] args) {
        //Input: points = [[3,3],[5,-1],[-2,4]], k = 2
        //Output: [[3,3],[-2,4]]
        //Explanation: The answer [[-2,4],[3,3]] would also be accepted.

    }
}
