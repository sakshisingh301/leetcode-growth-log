import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {

        Queue<int [] > queue=new LinkedList<>();
        int row= rooms.length;
        int column=rooms[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(rooms[i][j]==0)
                {
                    queue.add(new int []{i,j,0});
                }
            }
        }

        while(!queue.isEmpty())
        {
            int [] curr= queue.poll();
            int cRow=curr[0];
            int cCol=curr[1];
            int cDist=curr[2];

            int [] [] dir={{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int [] d: dir)
            {
                int nRow=cRow+d[0];
                int nCol=cCol+d[1];
                if(nRow>=0 && nCol>=0 && nRow<row && nCol<column && rooms[nRow][nCol]==2147483647 && rooms[nRow][nCol]!=-1)
                {
                    rooms[nRow][nCol]=cDist+1;
                    queue.add(new int [] { nRow,nCol,cDist+1});
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
