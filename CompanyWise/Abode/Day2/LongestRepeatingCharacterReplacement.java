package Abode.Day2;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        //valid window: windowsize-maximumFrequency<=k
        //if invalid then make it valid

        HashMap<Character, Integer> map=new HashMap<>();
        int start=0;
        int end=0;
        int maximumFrequency=0;
        int maxLength=0;


        while(end<s.length())
        {
            char currentChar=s.charAt(end);
            map.put(currentChar, map.getOrDefault(currentChar,0)+1);
            maximumFrequency=Math.max(maximumFrequency, map.get(currentChar));

                //invalid
                while ((end-start+1)-maximumFrequency>k)
                {
                    map.put(s.charAt(start),map.get(s.charAt(start))-1);
                    if(map.get(s.charAt(start))==0)
                    {
                        map.remove(s.charAt(start));

                    }
                    start++;
                }
                maxLength=Math.max(maxLength,end-start+1);
                end++;

        }
        return maxLength;

    }

    public static void main(String[] args) {
        String s="AABABBA";
        int k=1;
        System.out.println(characterReplacement(s,k));
    }

    //Input: s = "AABABBA", k = 1
    //Output: 4
    //Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    //The substring "BBBB" has the longest repeating letters, which is 4.
    //There may exists other ways to achieve this answer too.


}
