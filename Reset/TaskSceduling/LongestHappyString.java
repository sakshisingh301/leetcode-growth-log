package TaskSceduling;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {


        //max heap to store the most occuring element at the top
        //collections.reverseOrder() only works with Integer
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((x,y)->y[1]-x[1]);

        //push the character's frequency in the max heap
        if(a>0) maxHeap.add(new int[]{'a',a});
        if(b>0) maxHeap.add(new int[]{'b',b});
        if(c>0) maxHeap.add(new int[]{'c',c});

        StringBuilder stringBuilder=new StringBuilder();

        while(!maxHeap.isEmpty())
        {
            //start processing the most frequent element
           int[] mostFrequent= maxHeap.poll();
           char mostFrequentChar=(char)mostFrequent[0];
           int mostFrequentCount=mostFrequent[1];

           if(stringBuilder.length()>=2 && stringBuilder.charAt(stringBuilder.length()-1)==mostFrequentChar
           && stringBuilder.charAt(stringBuilder.length()-2)==mostFrequentChar)
           {
               if(maxHeap.peek()==null)
               {
                   break;
               }

               int [] secondMostFrequent=maxHeap.poll();
               char secondMostFrequentChar= (char)secondMostFrequent[0];
               int secondMostFrequentCount=secondMostFrequent[1];
               stringBuilder.append(secondMostFrequentChar);
               secondMostFrequentCount--;
               if(secondMostFrequentCount>0)
               {
                   maxHeap.add(new int[]{secondMostFrequentChar,secondMostFrequentCount});
               }
            }
           else {
               //starting chars
               stringBuilder.append(mostFrequentChar);
               mostFrequentCount--;


           }
           if(mostFrequentCount>0)
           {
               maxHeap.add(new int[]{mostFrequentChar,mostFrequentCount});
           }
        }
        return stringBuilder.toString();

    }
    //Example 1:
    //
    //Input: a = 1, b = 1, c = 7
    //Output: "ccaccbcc"
    //Explanation: "ccbccacc" would also be a correct answer.
}
