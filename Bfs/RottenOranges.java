import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int []> queue=new LinkedList<>();
        int time=0;
        int fresh=0;
        int row=grid.length;
        int column=grid[0].length;
        boolean [] [] visited=new boolean[row][column];
       // it is a multi source BFS problem since it is asking me to return minimum time, so the BFS will start for all
        //rotten orange not just one

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(grid[i][j]==2)
                {
                    visited[i][j]=true;
                    queue.add(new int []{i,j,0});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        int tmax=0;
        int [][] dir={{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty())
        {
            int [] curr=queue.poll();
            int cRow=curr[0];
            int cCol=curr[1];
            int cTime=curr[2];
            tmax=Math.max(cTime,tmax);
            //travel in all four direction and make the fresh orange rotten

            for(int [] d: dir)
            {
                int nRow=cRow+d[0];
                int nCol=cCol+d[1];
                if(nRow<row && nCol<column && nRow>=0 && nCol>=0 && grid[nRow][nCol]==1 && !visited[nRow][nCol])
                {
                    grid[nRow][nCol]=2;
                    visited[nRow][nCol]=true;
                    queue.add(new int []{nRow,nCol, cTime+1});
                    fresh--;

                }


            }

        }
        return fresh==0?tmax:-1;

    }
}
