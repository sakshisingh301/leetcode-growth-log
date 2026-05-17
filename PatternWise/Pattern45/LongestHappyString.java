package Pattern45;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestHappyString {

    public String longestHappyString(int a , int b, int c) {

        //put the element && count in a hashmap
        //put it in max heap so that the element with higher frequency are at the top
        PriorityQueue<int []> maxHeap=new PriorityQueue<>((x,y)->y[1]-x[1]);
        if(a>0) {maxHeap.add(new int[]{'a',a});}
        if(b>0) {maxHeap.add(new int[]{'b',b});}
        if(c>0) {maxHeap.add(new int[]{'c',c});}
        StringBuilder stringBuilder=new StringBuilder();

        while (!maxHeap.isEmpty())
        {
            //get the most frequent letter
            int [] mostFrequent= maxHeap.poll();
            char curr= (char) mostFrequent[0];
            int frequency=mostFrequent[1];
            //if the current character is similar to last 2 character
            if(stringBuilder.length()>=2  && curr==stringBuilder.charAt(stringBuilder.length()-1) &&
            curr==stringBuilder.charAt(stringBuilder.length()-2))
            {
                if(maxHeap.isEmpty())
                {
                    break;
                }
                int [] secondMostFrequentCharacter=maxHeap.poll();

                char secondMostFrequentChar=(char) secondMostFrequentCharacter[0];
                int secondMostFrequency=secondMostFrequentCharacter[1];
                stringBuilder.append(secondMostFrequentChar);
                secondMostFrequency--;
                if(secondMostFrequency>0)
                {
                    maxHeap.add(new int[]{secondMostFrequentChar,secondMostFrequency});
                }


            }
            else {
                stringBuilder.append(curr);
                frequency--;
            }
            if(frequency>0)
            {
                maxHeap.add(new int[]{curr,frequency});
            }


        }
        return stringBuilder.toString();


    }

    //Input: a = 1, b = 1, c = 7
    //Output: "ccaccbcc"
    //Explanation: "ccbccacc" would also be a correct answer.
}
