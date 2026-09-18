package MatrixSimulation;

import java.util.Arrays;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        int row=board.length;
        int column=board[0].length;
        int [] [] result=new int[row][column];





        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                int count=0;
                int current=board[i][j];
                int [][] dirs={{1,0},{-1,0},{0,1},{0,-1}, {1,1},{-1,1},{1,-1},{-1,-1}};

                //if the cell is dead then check how many cells are live by interacting with 8 neighbours
                if(current==0)
                {
                    for(int [] dir: dirs)
                    {
                        int nRow=i+dir[0];
                        int nCol=j+dir[1];
                        if(nRow>=0 && nCol>=0 && nRow<board.length && nCol<board[0].length)
                        {
                            if(board[nRow][nCol]==1)
                            {
                                count++;
                            }

                        }


                    }
                    if(count==3)
                    {
                        //update the result matrix
                        result[i][j]=1;
                    }
                    count=0;

                }
                //alive cell
                else {
                    for(int [] dir: dirs) {
                        int nRow = i + dir[0];
                        int nCol = j + dir[1];
                        if(nRow>=0 && nCol>=0 && nRow<board.length && nCol<board[0].length)
                        {
                            if(board[nRow][nCol]==1)
                            {
                                count++;
                            }

                        }

                    }
                    if(count<2)
                    {
                        result[i][j]=0;
                    } else if (count>3) {
                        //dead
                        result[i][j]=0;
                    }
                    else {
                        result[i][j] = 1;
                    }
                    count=0;

                }





            }
        }

        //copy result to board
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
               board[i][j]= result[i][j];
            }
        }

    }

    public static void main(String[] args) {
        //Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
        //Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

    }

//    public boolean canAttendMeetings(int[][] intervals) {
//
//        //sort it by start time
//        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
//        int[] first=intervals[0];
//        int start=first[0];
//        int end=first[1];
//
//        for(int i=1;i< intervals.length;i++)
//        {
//            int[] curr=intervals[i];
//            int currStart=curr[0];
//            int currEnd=curr[1];
//            //check if there is an intersection
//            if(end> currStart)
//            {
//                return false;
//            }
//            else {
//                end=currEnd;
//            }
//        }
//        return true;
//
//    }
    //intervals = [[0,30],[5,10],[15,20]]
}
