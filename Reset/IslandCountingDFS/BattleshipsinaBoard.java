package IslandCountingDFS;

public class BattleshipsinaBoard {

    public int countBattleships(char[][] board) {

        int row=board.length;
        int column=board[0].length;
        boolean[] []visited=new boolean[row][column];
        int battleShip=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(board[i][j]=='X' &&!visited[i][j])
                {
                    dfs(board,i,j,visited);
                    battleShip++;

                }
            }
        }
        return battleShip;

    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if(i<0 || j<0 || i>=board.length|| j>=board[0].length || board[i][j]=='.'||visited[i][j])
        {
            return;
        }

        visited[i][j]=true;
        dfs(board, i+1,j,visited);
        dfs(board, i,j+1,visited);
        dfs(board, i-1,j,visited);
        dfs(board, i,j-1,visited);

    }

    //Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
    //Output: 2
}
