package IslandCountingBFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int row= mat.length;
        int column=mat[0].length;
        int [][] result=new int[row][column];

        Queue<int[]> queue=new LinkedList<>();

        boolean[][] visited=new boolean[row][column];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new int[]{i,j,0});
                    result[i][j]=0;
                }
            }
        }

        while(!queue.isEmpty())
        {
            int [] curr=queue.poll();
            int currRow= curr[0];
            int currColumn=curr[1];
            int currDist=curr[2];

            int [][] dir={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int [] d: dir)
            {
                int nRow=currRow+d[0];
                int nCol=currColumn+d[1];
                if(nRow<=row && nCol<=column && nRow>=0 && nCol>=0 &&mat[nRow][nCol]==1 && !visited[nRow][nCol])
                {
                    visited[nRow][nCol]=true;
                    queue.add(new int[]{nRow,nCol,currDist+1});
                    result[nRow][nCol]=currDist+1;

                }
            }
        }
        return result;
    }

    //Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
    //Output: [[0,0,0],[0,1,0],[1,2,1]]
    //
}
