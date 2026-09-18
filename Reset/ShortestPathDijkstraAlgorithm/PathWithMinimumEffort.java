package ShortestPathDijkstraAlgorithm;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {

        //define min heap(effort, row,column)
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        minHeap.add(new int[]{0,0,0});
        boolean[][] visited=new boolean[heights.length][heights[0].length];
        int [][] bestEffort= new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                bestEffort[i][j]=Integer.MAX_VALUE;
            }
        }
        bestEffort[0][0]=0;



        while (!minHeap.isEmpty())
        {
            int[] curr=minHeap.poll();
            int currEffort=curr[0];
            int row=curr[1];
            int column=curr[2];
            //get all the neighbour by moving to up, down, right, left
            int [][] dirs={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int[] dir: dirs)
            {
                int nRow=row+dir[0];
                int nCol=column+dir[1];
                if(nRow<0 || nCol<0 || nRow>=heights.length || nCol>=heights[0].length)
                {
                    continue;
                }
                int edgeDifference=Math.abs(heights[row][column]-heights[nRow][nCol]);
                int newEfort=Math.max(edgeDifference,currEffort);
                //we are trying to store minimum effort
                if(newEfort<bestEffort[nRow][nCol])
                {
                    bestEffort[nRow][nCol]=newEfort;
                    minHeap.add(new int[]{newEfort,nRow,nCol});
                }

            }



        }

        return bestEffort[heights.length-1][heights[0].length-1];

    }

    public static void main(String[] args) {
        //Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
        //Output: 1
        //Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

    }
}
