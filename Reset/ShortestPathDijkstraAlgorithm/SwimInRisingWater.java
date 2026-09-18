package ShortestPathDijkstraAlgorithm;

import java.util.PriorityQueue;

public class SwimInRisingWater {

    public int swimInWater(int[][] grid) {
        //Dijstra algo
        //(height, row, column)
        PriorityQueue<int []> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean [] [] visited=new boolean[grid.length][grid[0].length];
        minHeap.add(new int[]{grid[0][0],0,0});
        int [] [] minimumWait=new int[grid.length][grid[0].length];
        //decide what to fill up
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                minimumWait[i][j]=Integer.MAX_VALUE;
            }
        }
        minimumWait[0][0]=grid[0][0];


        while(!minHeap.isEmpty())
        {
            int [] curr=minHeap.poll();
            int height=curr[0];
            int row=curr[1];
            int column=curr[2];
            if(visited[row][column])
            {
                continue;
            }
            visited[row][column]=true;
            int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

            for(int [] dir: dirs)
            {

                int nRow=row+dir[0];
                int nCol=column+dir[1];

                if(nRow<0 || nCol<0 ||nRow>=grid.length || nCol>=grid[0].length)
                {
                    continue;
                }


                int newHeight=Math.max(grid[nRow][nCol],height);
                if(newHeight<minimumWait[nRow][nCol] && !visited[nRow][nCol])
                {
                    minHeap.add(new int[]{newHeight, nRow,nCol});
                    minimumWait[nRow][nCol]=newHeight;
                }



            }

        }
        return minimumWait[grid.length-1][grid[0].length-1];


    }
    //Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
    //Output: 16
    //Explanation: The final route is shown.
    //We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
}
