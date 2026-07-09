package IslandCountingBFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        int row= grid.length;
        int column=grid[0].length;
        int freshOrange=0;
        Queue<int [] > queue=new LinkedList<>();
        boolean[][] visited=new boolean[row][column];
        int minTime=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(grid[i][j]==1)
                {
                    freshOrange++;
                }
                if(grid[i][j]==2)
                {
                    queue.add(new int []{i, j,0});
                }
            }
        }

        while(!queue.isEmpty())
        {
            int [] curr= queue.poll();
            int nRow=curr[0];
            int nCol=curr[1];
            int nTime=curr[2];
            minTime=Math.max(minTime,nTime);

            int [][] dirs={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int [] dir: dirs)
            {
                int cRow=nRow+dir[0];
                int cCol=nCol+dir[1];
                if(cRow<row && cCol<column && cRow>=0 && cCol>=0 && grid[cRow][cCol]==1 && !visited[cRow][cCol])
                {
                   visited[cRow][cCol]=true;
                    queue.add(new int[]{cRow,cCol,nTime+1});
                    freshOrange--;
                }
            }
        }
        if(freshOrange>0)
        {
            return -1;
        }
        return minTime;

    }
    //Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
    //Output: 4
    //Example 2:
    //
    //Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
    //Output: -1
    //Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
}
