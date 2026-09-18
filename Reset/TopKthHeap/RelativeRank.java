package TopKthHeap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class RelativeRank {

    public String[] findRelativeRanks(int[] score) {

        String [] strings=new String[score.length];


        //maxheap(number, index)
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int i=0;i< score.length;i++)
        {
            maxHeap.add(new int[]{score[i],i});
        }
        int rank=1;

        while(!maxHeap.isEmpty())
        {
            int [] curr=maxHeap.poll();

            int index=curr[1];
            if(rank==1)
            {
                strings[index]= "Gold Medal";

            }
            else if(rank==2)
            {
                strings[index]= "Silver Medal";

            }
            else if(rank==3)
            {
                strings[index]= "Bronze Medal";

            }
            else
            {
                strings[index]=String.valueOf(rank);
            }
            rank++;


        }
        return strings;

    }

    public static void main(String[] args) {
        //[10,3,8,9,4]

    }
}
