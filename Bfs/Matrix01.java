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

}
