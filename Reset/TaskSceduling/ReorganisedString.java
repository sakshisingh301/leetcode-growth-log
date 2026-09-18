package TaskSceduling;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganisedString {

    public String reorganizeString(String s) {

        //Max heap to store the character and count
        //for that you need hashmap
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<int []> maxHeap=new PriorityQueue<>((a,b)-> b[1]-a[1]);

        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            int key= entry.getKey();
            int value= entry.getValue();
            maxHeap.add(new int[]{key,value});

        }
        StringBuilder stringBuilder=new StringBuilder();

        while(!maxHeap.isEmpty())
        {
            int [] mostFrequent= maxHeap.poll();
            char mostFrequentChar=(char)mostFrequent[0];
            int mostFrequentCount=mostFrequent[1];
            //"aab"
            //a
            if(!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length()-1)==mostFrequentChar)
            {
                if(maxHeap.peek()==null)
                {
                    return "";
                }
                //poll the next greatest character
                int [] secondMostFrequent=maxHeap.poll();
                char secondMostChar=(char)secondMostFrequent[0];
                int secondMostCharCount=secondMostFrequent[1];

                stringBuilder.append(secondMostChar);
                secondMostCharCount--;
                if(secondMostCharCount>0)
                {
                    maxHeap.add(new int[]{secondMostChar,secondMostCharCount});
                }


            }
            else {
                stringBuilder.append(mostFrequentChar);
                mostFrequentCount--;
            }
            if(mostFrequentCount>0)
            {
                maxHeap.add(new int[]{mostFrequentChar, mostFrequentCount});
            }



        }
        return stringBuilder.toString();

    }

    //Example 1:
    //
    //Input: s = "aab"
    //Output: "aba"
    //Example 2:
    //
    //Input: s = "aaab"
    //Output: ""
}
