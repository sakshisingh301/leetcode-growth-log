package ShortestPathDijkstraAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMazeII {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        //min heap (row, column, distance)
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        minHeap.add(new int[]{0, start[0],start[1]});
        int [] [] distance=new int[maze.length][maze[0].length];
        for(int i=0;i<distance.length;i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]]=0;



        while(!minHeap.isEmpty())
        {
            int [] curr= minHeap.poll();
            int row=curr[1];
            int column=curr[2];
            int currDistance=curr[0];
            //4 direction call to reach till the wall
            int [][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

            for(int[] dir: dirs)
            {
                int nRow=row;
                int nCol=column;
                int nDistance=currDistance;
                while(nRow+dir[0]>=0 && nCol+dir[1]>=0 && nRow+dir[0]< maze.length && nCol+dir[1]<maze[0].length
                 && maze[nRow+dir[0]][nCol+dir[1]]==0)
                {
                    nRow=nRow+dir[0];
                    nCol=nCol+dir[1];
                    nDistance=nDistance+1;
                }
                if(nDistance<distance[nRow][nCol])
                {
                    minHeap.add(new int[]{ nDistance,nRow,nCol});
                    distance[nRow][nCol]=nDistance;
                }
            }





        }
        int ans= distance[destination[0]][destination[1]];
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;



    }
    //Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
    //Output: 12
    //Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
    //The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
}
