package IslandCountingBFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridWithObstacleseLimination {

    public int shortestPath(int[][] grid, int k) {

        //maintain row, column, no of obstacle in the path, steps from the source
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        //there might be path for reaching to the sam
        boolean [] [] visited=new boolean[grid.length][grid[0].length];
        visited[0][0]=true;

        while(!queue.isEmpty())
        {
            int [] curr=queue.poll();
            int row=curr[0];
            int column=curr[1];
            int noOfObstacle=curr[2];
            int step=curr[3];
            if(row== grid.length-1 && column==grid[0].length-1)
            {
                return step;

            }
            //go to their neighbour
            int [] [] dirs={{1,0},{0,1},{-1,0},{0,-1}};

            for(int [] dir: dirs)
            {
                int nRow=row+dir[0];
                int nCol=column+dir[1];
                //only add the element in the queue which are under valid limit and no of obstacle is less than or
                //equal to k
                //how do we keep track of no of obstacle


                if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && !visited[nRow][nCol])
                {

                    //if its a empty cell   
                    if(grid[nRow][nCol]==0)
                    {
                        queue.add(new int[]{nRow,nCol,noOfObstacle,step+1});
                        visited[nRow][nCol]=true;

                    }
                    //if it is an obstacle
                    else if(grid[nRow][nCol]==1 && noOfObstacle<k)
                    {
                        queue.add(new int[]{nRow,nCol,noOfObstacle+1, step+1});
                        visited[nRow][nCol]=true;
                    }


                }
            }
        }
        return -1;

    }
    //Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
    //Output: 6
    //Explanation:
    //The shortest path without eliminating any obstacle is 10.
    //The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
}
