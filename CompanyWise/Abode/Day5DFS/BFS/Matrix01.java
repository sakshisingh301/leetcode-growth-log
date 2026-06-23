package Abode.Day5DFS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {

        //multi source bfs

        Queue<int[]> queue=new LinkedList<>();


        int row=mat.length;
        int column=mat[0].length;
        int[][] result=new int[row][column];
        boolean[][] visited=new boolean[row][column];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new int[]{i, j,0});
                    visited[i][j]=true;
                    result[i][j]=0;
                }
            }
        }

        while(!queue.isEmpty())
        {
            int [] curr=queue.poll();
            int cRow=curr[0];
            int cCol=curr[1];
            int cDist=curr[2];
            int [][] dirs={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int [] dir: dirs)
            {
                int nRow=cRow+dir[0];
                int nCol=cCol+dir[1];
                if(mat[nRow][nCol]==1 && nRow< mat.length &&nCol<mat[0].length && nRow>0 && nCol>0 && !visited[nRow][nCol] )
                {
                    visited[nRow][nCol]=true;
                    queue.add(new int[]{nRow,nCol,cDist+1});
                    result[nRow][nCol]=cDist+1;
                }
            }


        }
        return result;



    }

    public static void main(String[] args) {
        //Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
        //Output: [[0,0,0],[0,1,0],[0,0,0]]

    }
}
