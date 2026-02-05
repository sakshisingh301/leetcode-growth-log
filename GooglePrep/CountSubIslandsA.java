public class CountSubIslandsA {

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int row= grid2.length;
        int column=grid2[0].length;
        int subIslands=0;

        boolean [][] visited=new boolean[row][column];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(!visited[i][j] && grid2[i][j]==1)
                {
                    boolean[] isSubLand=new boolean[]{true};
                    dfs(grid1,grid2,i,j,isSubLand,visited);
                    if(isSubLand[0])
                    {
                      subIslands++;
                    }

                }
            }
        }
        return subIslands;


    }

    private void dfs(int[][] grid1, int[][] grid2, int i, int j, boolean[] isSubLand, boolean[][] visited) {

        if(i<0 ||j<0|| i>=grid2.length || j>grid2[0].length || visited[i][j] || grid2[i][j]==0 )
        {
            return;
        }
        if(grid1[i][j]==0)
        {
            isSubLand[0]=false;
        }
        visited[i][j]=true;
        dfs(grid1,grid2,i+1,j,isSubLand,visited);
        dfs(grid1,grid2,i-1,j,isSubLand,visited);
        dfs(grid1,grid2,i,j+1,isSubLand,visited);
        dfs(grid1,grid2,i,j-1,isSubLand,visited);
    }

    public static void main(String[] args) {

    }
}
