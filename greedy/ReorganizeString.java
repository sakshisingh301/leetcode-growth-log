import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static String reorganizeString(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        PriorityQueue<int []> max_heap=new PriorityQueue<>(
                (x, y)->y[1]-x[1]
        );
        int [] frequency=new int[26];
        for(char curr: s.toCharArray())
        {
            frequency[curr-'a']++;
        }

        for(int i=0;i<26;i++)
        {
            if(frequency[i]!=0)
            {
                max_heap.add(new int[]{i+'a',frequency[i]});
            }
        }

        while(!max_heap.isEmpty())
        {
            int [] mostFrequent= max_heap.poll();
            char mostFrequentLetter=(char)mostFrequent[0];
            int mostFrequentCount=  mostFrequent[1];
            int len=stringBuilder.length();

            if(len>=1 && stringBuilder.charAt(len-1)==mostFrequentLetter)
            {
                if(max_heap.isEmpty())
                {
                    return "";
                }
                int [] secondMostFrequent= max_heap.poll();
                int secondMostFrequentCount=secondMostFrequent[1];
                char secondMostFrequentLetter= (char)secondMostFrequent[0];
                stringBuilder.append(secondMostFrequentLetter);
                secondMostFrequentCount--;
                if(secondMostFrequentCount>0)
                {
                    max_heap.add(new int []{secondMostFrequentLetter,secondMostFrequentCount});
                }

            }
            else {
                stringBuilder.append(mostFrequentLetter);
                mostFrequentCount--;
            }
            if(mostFrequentCount>0)
            {
                max_heap.add(new int[]{mostFrequentLetter,mostFrequentCount});
            }


        }
        return stringBuilder.toString();



    }

    public static void main(String[] args) {
       String s = "aaab";
       System.out.println(reorganizeString(s));
    }

    //s = "aab"



}
