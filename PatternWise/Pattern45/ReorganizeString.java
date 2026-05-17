package Pattern45;

import javax.swing.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s) {
       StringBuilder stringBuilder=new StringBuilder();
       PriorityQueue<int []> maxHeap=new PriorityQueue<>((a,b)->b[1]-a[1]);
       int [] frequencyString=new int[26];

       for(int i=0;i<s.length();i++)
       {
           frequencyString[s.charAt(i)-'a']++;
       }

       for(int i=0;i<26;i++)
       {
          if(frequencyString[i]!=0)
          {
              maxHeap.add(new int[]{i+'a',frequencyString[i]});
          }
       }

       while(!maxHeap.isEmpty())
       {
           int [] mostFrequent= maxHeap.poll();
           char curr=(char)mostFrequent[0];
           int mostFrequency=mostFrequent[1];
           if(!stringBuilder.isEmpty() && curr==stringBuilder.charAt(stringBuilder.length()-1))
           {
               if(maxHeap.isEmpty())
               {
                   return "";
               }
               int [] secondMost=maxHeap.poll();
               char secondMostCharacter=(char) secondMost[0];
               int secondMostFrequency=secondMost[1];
               stringBuilder.append(secondMostCharacter);
               secondMostFrequency--;
               if(secondMostFrequency>0)
               {
                   maxHeap.add(new int[]{secondMostCharacter,secondMostFrequency});
               }

           }
           else {
               stringBuilder.append(curr);
               mostFrequency--;
           }

           if(mostFrequency>0)
           {
               maxHeap.add(new int[]{curr,mostFrequency});
           }
       }
       return stringBuilder.toString();

    }

}
//Input: s = "aab"
//Output: "aba"
//s = "aaab"