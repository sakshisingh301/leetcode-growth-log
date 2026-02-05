import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {

        Queue<int []> queue=new LinkedList<>();

        int row= mat.length;
        int column=mat[0].length;
        boolean [] [] visited=new boolean[row][column];
        int [][] result=new int[row][column];

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
            int [] curr= queue.poll();
            int cRow=curr[0];
            int cCol=curr[1];
            int cDist=curr[2];
            int [][] dir={{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int [] d : dir)
            {
                int nRow=cRow+d[0];
                int nCol=cCol+d[1];
                if(nRow>=0 && nCol>=0 && nRow<row && nCol<column && !visited[nRow][nCol] && mat[nRow][nCol]==1)
                {
                    visited[nRow][nCol]=true;
                    queue.add(new int[]{nRow,nCol, cDist+1});
                    result[nRow][nCol]= cDist+1;
                }
            }
        }
        return result;

    }

    public int[][] updateMatrix1(int[][] mat) {

        Queue<int []> queue=new LinkedList<>();
        boolean [] [] visited=new boolean[mat.length][mat[0].length];

        int [] [] res=new int[mat.length][mat[0].length];
        for(int i=0;i< mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new int[]{i,j,0});
                    res[i][j]=0;
                    visited[i][j]=true;
                }
            }
        }

        while(!queue.isEmpty())
        {
            int [] curr= queue.poll();
            int row=curr[0];
            int column=curr[1];
            int dist=curr[2];
            int [][] dir={{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int [] d: dir)
            {
                int nRow=row+d[0];
                int nColumn=column+d[1];

                if(nRow>=0 && nRow< mat.length && nColumn>=0 && nColumn<mat[0].length && mat[nRow][nColumn]==1 && !visited[nRow][nColumn])
                {
                    visited[nRow][nColumn]=true;
                    queue.add(new int[]{nRow,nColumn,dist+1});
                    res[nRow][nColumn]=dist+1;

                }
            }

        }
        return res;



    }

}
