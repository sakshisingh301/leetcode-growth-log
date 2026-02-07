import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToTheFood {

    public int getFood(char[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int row= grid.length;
        int column=grid[0].length;
        boolean [][] visited=new boolean[row][column];
        int minimumDistance=0;
        //starting point will be *

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(grid[i][j]=='*')
                {
                    queue.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }

        while(!queue.isEmpty())
        {
            int [] curr=queue.poll();
            int cRow=curr[0];
            int cCol=curr[1];
            int cDist=curr[2];

            int [] [] dir={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int [] d: dir)
            {
                int nRow=cRow+d[0];
                int nCol=cCol+d[1];
                if(nRow>=0 && nRow<row &&nCol>=0 && nCol<column && !visited[nRow][nCol] &&grid[nRow][nCol]!='X')
                {
                    if(grid[nRow][nCol]=='#')
                    {
                        minimumDistance=cDist+1;
                        return minimumDistance;
                    }

                    queue.add(new int[]{nRow,nCol,cDist+1});
                    visited[nRow][nCol]=true;

                }
            }

        }
        return -1;




    }


    public static void main(String[] args) {
        //grid = [["X","X","X","X","X","X"]
        // ,["X","*","O","O","O","X"],
        // ["X","O","O","#","O","X"],
        // ["X","X","X","X","X","X"]]

    }
}
