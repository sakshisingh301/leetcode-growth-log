package Abode.Day2;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map=new HashMap<>();
        int start=0;
        int end=0;
        int longestLength=0;
        while(end<s.length())
        {
            char curr=s.charAt(end);
            map.put(curr, map.getOrDefault(curr,0)+1);

            while(map.size()!=end-start+1)
                {
                    if(map.containsKey(s.charAt(start)))
                    {
                        map.put(s.charAt(start), map.get(s.charAt(start))-1);
                        if(map.get(s.charAt(start))==0)
                        {
                            map.remove(s.charAt(start));
                        }
                    }
                    start++;
                }

            longestLength=Math.max(end-start+1, longestLength);
            end++;


        }
        return longestLength;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

}
