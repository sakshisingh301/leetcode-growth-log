package Abode.Day5DFS.DFS;

public class SourroundedRegion {

    public void solve(char[][] board) {
        //run DFS call from the border, check if you identify 0 convert it to S, c

        int row=board.length;
        int column=board[0].length;

        //top && bottom
        for(int i=0;i<column;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(board,0,i);
            }
            if(board[row-1][i]=='O')
            {
                dfs(board,row-1,i);
            }
        }
        //left && right
        for(int i=0;i<row;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(board,i,0);
            }
            if(board[i][column-1]=='O')
            {
                dfs(board,i,column-1);
            }
        }

        //convert 0 to X and S to 0

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(board[i][j]=='S')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }



    }

    private void dfs(char[][] board, int i, int j ) {

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='X' || board[i][j]=='S')
        {
            return;
        }

        board[i][j]='S';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);

    }

    //Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    //
    //Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
}
