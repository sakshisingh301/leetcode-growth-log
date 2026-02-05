public class NumberOfClosedIslandA {

   //island will be closed if it is sourrounded by water(1)
    //island is 0 here
    //if there is an island at the edges then it cannot closed so we dont need to check edges
    public int closedIsland(int[][] grid) {

        int row=grid.length;
        int column=grid[0].length;
        boolean[] [] visited=new boolean[row][column];

        int closedIslands=0;

        for(int i=1;i<row-1;i++)
        {
            for(int j=1;j<column-1;j++)
            {
                if(!visited[i][j] && grid[i][j]==0)
                {
                    boolean[] isClosed = new boolean[]{true};
                    dfs(grid,i,j,visited,isClosed);
                    if(isClosed[0])
                    {
                        closedIslands++;
                    }
                }

            }
        }
        return closedIslands;

    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, boolean[] isClosed) {


        if(i<0 ||j<0|| i>= grid.length || j>=grid[0].length|| visited[i][j] || grid[i][j]==1)
        {
            return;
        }

        //when the island is not closed
        if( i==grid.length-1 || j==grid[0].length-1 ||i==0 || j==0  )
        {
            isClosed[0]=false;
        }

        visited[i][j]=true;
        dfs(grid, i+1,j,visited,isClosed);
        dfs(grid, i-1,j,visited,isClosed);
        dfs(grid, i,j+1,visited,isClosed);
        dfs(grid, i,j-1,visited,isClosed);


    }

    public static void main(String[] args) {

    }
}
