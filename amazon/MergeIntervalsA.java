import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervalsA {

    public int[][] merge(int[][] intervals) {


       //sort this by starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        ArrayList<int []> res=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        int index=1;

        while(index< intervals.length)
        {
            //overlap
            if(end>=intervals[index][0])
            {
                end=Math.max(end, intervals[index][1]);

            }
            else {
                res.add(new int[]{start,end});
                //move the start to current
                start=intervals[index][0];
                end=intervals[index][1];

            }

            index++;
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][0]);


    }

    //intervals = [[1,3],[2,6],[8,10],[15,18]]
}
