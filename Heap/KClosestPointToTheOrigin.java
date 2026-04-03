import java.util.PriorityQueue;

public class KClosestPointToTheOrigin {
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res=new int[k][2];
        //define maxheap
        PriorityQueue<int[]> max_heap=new PriorityQueue<>((a, b)->b[0]-a[0]);
        //iterate through the points and calculate distance and start putting in heap
        for(int [] p: points)
        {
            int x=p[0];
            int y=p[1];
            int d= y*y+x*x;
            max_heap.add(new int []{d, x, y});

            if(max_heap.size()>k)
            {
                max_heap.poll();
            }

        }
        int i=0;

        while(max_heap.size()>0)
        {

            int [] temp= max_heap.poll();
            //add the temp in res
            res[i][0]=temp[1];
            res[i][1]=temp[2];
            i++;

        }
        return res;


    }
}