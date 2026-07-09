package IslandCountingDFS;

public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        int row= grid.length;
        int column=grid[0].length;
        int numOfIsland=0;


        boolean[][] visited=new boolean[row][column];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    dfs(grid, i, j, visited);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;

    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]=='0')
        {
            return;
        }

        visited[i][j]=true;
        dfs(grid,i+1,j,visited);
        dfs(grid,i, j+1, visited);
        dfs(grid, i-1,j,visited);
        dfs(grid,i,j-1, visited);

    }

    //Example 1:
    //
    //Input: grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    //]
    //Output: 1
}
