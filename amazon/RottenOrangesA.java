import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesA {

    public int orangesRotting(int[][] grid) {

        //BFS

        Queue<int []> queue=new LinkedList<>();
        int row= grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int fresh=0;
        //push all the rotten ones to the queue(row, column, time)

        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new int []{i,j,0});
                    visited[i][j]=true;

                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        int [] [] direction={{-1,0},{1,0},{0,1},{0,-1}};
        int tMax=0;

        while(!queue.isEmpty())
        {
            int [] current=queue.poll();
            int nRow=current[0];
            int nCol=current[1];
            int cTime=current[2];
            tMax=Math.max(cTime,tMax);

            for(int [] dir: direction)
            {
                int cRow=nRow+dir[0];
                int cCol=nCol+dir[1];

                if(cRow<row && cCol<col && cRow>=0 && cCol>=0 && grid[nRow][nCol]==1 && !visited[nRow][nCol])
                {
                    queue.add(new int[]{cRow,cCol,cTime+1});
                    visited[cRow][cCol]=true;
                    fresh--;
                }
            }

        }
        return fresh==0?tMax:-1;

    }


}
