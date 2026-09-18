//package Interval;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class MergeInterval {
//
//    public int[][] merge(int[][] intervals) {
//
//        //sort by first variable
//        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
//        List<int [][]> result=new ArrayList<>();
//
//        int start=-1;
//        int i=0;
//        int prevStart=intervals[0][0];
//        int prevEnd=intervals[0][1];
//        for(int j=1;j< intervals.length;j++)
//        {
//            //is it overlapping? if yes then find new start and new end
//           //if it is overlapping then then find the new start and else
//
//            if(prevStart>intervals[j][0])
//            {
//                while(prevStart>intervals[j][0])
//                {
//
//                }
//            }
//            else
//            {
//                result.add(new int[]{prevStart, prevEnd})
//            }
//
//            //if it is not overlapping then simply add the start and end in the result
//
////
//
//
//
//
//
//        }
//
//    }
//
//    //Example 1:
//    //
//    //Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    //Output: [[1,6],[8,10],[15,18]]
//    //Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//
//}
