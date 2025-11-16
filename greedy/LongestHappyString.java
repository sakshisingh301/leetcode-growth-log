import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestHappyString {

    public static String longestDiverseString(int a, int b, int c) {

        PriorityQueue<int [] > max_heap=new PriorityQueue<>(
                (x,y) ->y[1]-x[1]
        );
        StringBuilder stringBuilder=new StringBuilder();
        if(a>0) max_heap.add(new int[]{'a',a});
        if(b>0) max_heap.add(new int[]{'b',b});
        if(c>0) max_heap.add(new int[]{'c',c});

        while(!max_heap.isEmpty())
        {
            int [] mostFrequent=max_heap.poll();
            char curr= (char) mostFrequent[0];
            int frequency=mostFrequent[1];
            //if the length is less than or equal to 2 then start appending to the stringbuilder
            if(stringBuilder.length()>=2 && curr==stringBuilder.charAt(stringBuilder.length()-1) && curr== stringBuilder.charAt(stringBuilder.length()-2))
            {
                if(max_heap.isEmpty())
                {
                    break;
                }
                int [] secondFrequent= max_heap.poll();
                char secondChar=(char) secondFrequent[0];
                int secondFrequency=secondFrequent[1];
                stringBuilder.append(secondChar);
                secondFrequency--;
                if(secondFrequency>0)
                {
                    max_heap.add(new int [] {secondChar, secondFrequency});
                }


            }
            else {
                stringBuilder.append(curr);
                frequency--;

            }
            if(frequency>0)
            {
                max_heap.add(new int[]{curr,frequency});
            }



        }
        return stringBuilder.toString();








    }

    public static void main(String[] args) {
    int a=7;
    int b=1;
    int c=0;
    System.out.println(longestDiverseString(a,b,c));


    }

    //Input: a = 1, b = 1, c = 7
    //Output: "ccaccbcc"
}
