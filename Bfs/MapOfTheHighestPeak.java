import java.util.LinkedList;
import java.util.Queue;

public class MapOfTheHighestPeak {

    public int[][] highestPeak(int[][] isWater) {

        Queue<int []> queue=new LinkedList<>();
        int row=isWater.length;
        int column=isWater[0].length;
        int [] [] res=new int[row][column];

        boolean[][] visited=new boolean[row][column];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(isWater[i][j]==1)
                {
                    visited[i][j]=true;
                    queue.add(new int[]{i,j,0});
                    res[i][j]=0;

                }
            }
        }

        while (!queue.isEmpty())
        {
            int [] curr=queue.poll();
            int nRow=curr[0];
            int nCol=curr[1];
            int nDist=curr[2];

            int [] [] dir={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int []d: dir)
            {
                int cRow=nRow+d[0];
                int cCol=nCol+d[1];

                if(cRow>=0 && cRow<isWater.length && cCol>=0 && cCol<isWater[0].length && !visited[cRow][cCol] && isWater[cRow][cCol]==0)
                {
                    visited[cRow][cCol]=true;
                    queue.add(new int []{cRow,cCol, nDist+1});
                    res[cRow][cCol]=nDist+1;
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        //isWater = [[0,0,1],[1,0,0],[0,0,0]]

    }
}
