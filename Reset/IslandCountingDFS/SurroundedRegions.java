package IslandCountingDFS;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int row=board.length;
        int column=board[0].length;
        //iterate through top, bottom, left, right and mark all the surrounding region with some letter say S
        //Ist row
        for(int i=0;i<column;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(board,0,i);
            }

        }
        //last row
        for(int i=0;i<column;i++)
        {
            if(board[row-1][i]=='O')
            {
                dfs(board,row-1, i);
            }

        }
        //first column
        for(int i=0;i<row;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(board,i,0);
            }

        }
        //last column
        for(int i=0;i<row;i++)
        {
            if(board[i][column-1]=='O') {
                dfs(board, i, column - 1);
            }
        }

        //convert remaining 0 to X
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
        //convert s to X back
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(board[i][j]=='S')
                {
                    board[i][j]='O';
                }
            }
        }


    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O')
        {
            return;
        }

        board[i][j]='S';
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i,j-1);


    }

    //Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    //
    //Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
}
