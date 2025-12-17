public class RangeSumQuery2DImmutable {
    int [][] prefix;
    //create precompute matrix
    public RangeSumQuery2DImmutable(int[][] matrix) {
        prefix=new int[matrix.length][matrix[0].length];
        int row= matrix.length;
        int column= matrix[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                //matrix[i][j]+top+left-overlap
                int left=(j>0)? prefix[i][j-1]: 0;
                int top=(i>0) ? prefix[i-1][j]:0;
                int overlap=(i>0 && j>0) ? prefix[i-1][j-1]:0;
                prefix[i][j]=matrix[i][j]+left+top-overlap;
            }
        }



    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum=prefix[row2][col2];
        int top= (row1>0)? prefix[row1-1][col2]:0;
        int left=(col1>0)? prefix[row2][col1-1]: 0;
        int overlap=(row1>0 && col1>0)? prefix[row1-1][col1-1]:0;
        return sum-top-left+overlap;





    }
}
