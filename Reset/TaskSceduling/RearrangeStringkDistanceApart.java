package TaskSceduling;

import java.util.*;

public class RearrangeStringkDistanceApart {

    public static String rearrangeString(String s, int k) {

        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<int []> maxHeap=new PriorityQueue<>((a, b)-> b[1]-a[1]);

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
        Queue<int[]> waitingQueue=new LinkedList<>();

        while(!maxHeap.isEmpty())
        {
            int [] mostFrequent=maxHeap.poll();
            char mostFrequentChar=(char)mostFrequent[0];
            int mostFrequentCount=mostFrequent[1];
            stringBuilder.append(mostFrequentChar);
            mostFrequentCount--;
            waitingQueue.add(new int[]{mostFrequentChar, mostFrequentCount});

            while(waitingQueue.size()>=k)
            {
                int [] wait=waitingQueue.poll();
                if(wait!=null && wait[1]>0)
                {
                    maxHeap.add(wait);
                }
            }

        }
        if(stringBuilder.toString().length()!=s.length())
        {
            return "";
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
      String  s = "aabbcc";
      int k = 3;
      System.out.println(rearrangeString(s, k));
    }
    //Input: s = "aabbcc", k = 3
    //Output: "abcabc"
    //Explanation: The same letters are at least a distance of 3 from each other.
}
