package IslandCountingBFS;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGate {


    public void wallsAndGates(int[][] rooms) {

        int row= rooms.length;
        int column=rooms[0].length;

        Queue<int []> queue=new LinkedList<>();

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(rooms[i][j]==0)
                {
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        while (!queue.isEmpty())
        {
            int [] curr=queue.poll();
            int nRow=curr[0];
            int nCol=curr[1];
            int nDist=curr[2];

            int [][] dirs={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int [] d: dirs)
            {
                int cRow=nRow+d[0];
                int cCol=nCol+d[1];
                if(cRow<row && cCol<column && cRow>=0 && cCol>=0 && rooms[cRow][cCol]==2147483647 && rooms[cRow][cCol]!=-1)
                {
                    rooms[cRow][cCol]=nDist+1;
                    queue.add(new int[]{cRow,cCol,nDist+1});

                }
            }
        }



    }
}

//Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
//Example 2:
//
//Input: rooms = [[-1]]
//Output: [[-1]]
