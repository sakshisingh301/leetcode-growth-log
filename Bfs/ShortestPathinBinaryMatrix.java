import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row= grid.length;
        int column=grid[0].length;


        boolean [] [] visited=new boolean[row][column];
        Queue<int [] > queue=new LinkedList<>();
        if(grid[0][0]==1 || grid[row-1][column-1]==1) return -1;
        queue.add(new int[]{0,0,1});

        while (!queue.isEmpty())
        {
           int [] curr=queue.poll();
           int cRow=curr[0];
           int cCol=curr[1];
           int cTime=curr[2];
           if( cRow==row-1 && cCol==column-1) return cTime;

           int [] []dir={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

           for(int [] d: dir)
           {
               int nRow=cRow+d[0];
               int nCol=cCol+d[1];


               if(nRow>=0 && nCol>=0 && nRow<row && nCol<column && !visited[nRow][nCol] && grid[nRow][nCol]==0)
               {
                   visited[nRow][nCol]=true;
                   queue.add(new int[]{nRow,nCol,cTime+1});
               }
           }
        }
        return -1;


    }



    public int shortestPathBinaryMatrixAgain(int[][] grid) {

        Queue<int [] > queue=new LinkedList<>();
        int row= grid.length;
        int column=grid[0].length;
        boolean [] [] visited=new boolean[row][column];

        if(grid[0][0]!=0 || grid[row-1][column-1]!=0) return -1;
        queue.add(new int []{0,0,1});
        visited[0][0]=true;
        while(!queue.isEmpty())
        {
            int [] curr= queue.poll();
            int nRow=curr[0];
            int nCol=curr[1];
            int nPath=curr[2];
            if(nRow==row-1 && nCol==column-1) return nPath;

            int [] []dir={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
            for(int [] d: dir)
            {
                int cRow=nRow+d[0];
                int cCol=nCol+d[1];
                if(cRow>=0 && cRow<row && cCol>=0 && cCol<column && grid[cRow][cCol]==0 && !visited[cRow][cCol])
                {
                    visited[cRow][cCol]=true;
                    queue.add(new int[]{cRow,cCol,nPath+1});

                }
            }
        }
        return -1;


    }

    public static void main(String[] args) {

        //grid = [[0,0,0],[1,1,0],[1,1,0]]

    }
}
