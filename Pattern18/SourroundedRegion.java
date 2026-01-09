public class SourroundedRegion {


    public void solve(char[][] board) {

        //iterate on the boundaries and run DFS and convert all connected components into letter S
        int row=board.length;
        int column=board[0].length;
        //top and bottom
        for(int i=0;i<column;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(board,0,i);
            }
            if(board[row-1][i]=='O')
            {
                dfs(board,row-1,i );
            }
        }
        //left and right most
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

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                if(board[i][j]=='S')
                {
                    board[i][j]='O';
                }
            }
        }





    }

    private void dfs(char[][] board, int i, int j) {
        //breaking condition
        if(i<0 || j<0 || i>=board.length || j>=board[0].length ||board[i][j]=='X' || board[i][j]=='S')
        {
            return;
        }


        board[i][j]='S';
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i,j-1);


    }

    public static void main(String[] args) {
        //board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

    }
}
