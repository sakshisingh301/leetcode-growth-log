package Abode.Day1;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        //sort it by start
        //if there is a overlap then new start=Math.min(start1,start2) && new end=Math.max(end1,end2)

        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        ArrayList<int[]> res=new ArrayList<>();


        int prevStart=intervals[0][0];
        int prevEnd=intervals[0][1];
        int index=1;
        while (index< intervals.length)
        {
            int [] current=intervals[index];
            int currStart=current[0];
            int currEnd=current[1];
            if(prevEnd>currStart) {

                while(prevEnd>currStart) {
                    prevEnd=Math.max(prevEnd,currEnd);

                }

            }
            else {
                res.add(new int [] {prevStart,prevEnd});
            }

            index++;

        }



        return res.toArray(new int[0][0]);



    }

    public static void main(String[] args) {
        int [] [] intervals={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }
    // intervals = [[1,3],[2,6],[8,10],[15,18]]
}
