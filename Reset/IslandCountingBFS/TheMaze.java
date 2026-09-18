package IslandCountingBFS;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{start[0],start[1]});
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]]=true;

        while(!queue.isEmpty())
        {
            int [] curr= queue.poll();
            int row=curr[0];
            int column=curr[1];

            //travel in all four direction until you hit the wall
            int [][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

            for(int [] dir: dirs)
            {
                int nRow=row;
                int nCol=column;
                while(nRow+dir[0]>=0 && nCol+dir[1]>=0 && nRow+ dir[0]< maze.length && nCol+dir[1]<maze[0].length
                 && maze[nRow+dir[0]][nCol+dir[1]]==0 )
                {
                    nRow=nRow+dir[0];
                    nCol=nCol+dir[1];

                }
                if(!visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
                if(nRow==destination[0] && nCol==destination[1])
                {
                    return true;
                }
            }
        }
        return false;

    }
    //Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
    //Output: true
    //Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
}
