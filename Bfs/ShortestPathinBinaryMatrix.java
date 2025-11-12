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

    public static void main(String[] args) {

    }
}
