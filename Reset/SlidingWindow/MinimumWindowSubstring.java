package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


    public String minWindow(String s, String t) {

        int start=0;
        int end=0;
        HashMap<Character, Integer> mapForT=new HashMap<>();
        HashMap<Character, Integer> mapForS=new HashMap<>();
        String result="";
        int minWindow=Integer.MAX_VALUE;

        for(int i=0;i<t.length();i++)
        {
            mapForT.put(t.charAt(i), mapForT.getOrDefault(t.charAt(i),0)+1);

        }
        int formed=0;
        int required=mapForT.size();

        while(end<s.length())
        {
            mapForS.put(s.charAt(end),mapForS.getOrDefault(s.charAt(end),0)+1);
            //is window valid if yes then calculate the length
            if(mapForT.containsKey(s.charAt(end)) && mapForS.get(s.charAt(end)).equals(mapForT.get(s.charAt(end))))
            {
                formed++;
            }
            while(formed==required)
            {
                if(minWindow>end-start+1)
                {
                    minWindow= Math.min(minWindow,end-start+1);
                    result=s.substring(start,end+1);
                }
                char leftChar=s.charAt(start);
                mapForS.put(leftChar,mapForS.get(leftChar)-1);

                if(mapForT.containsKey(s.charAt(start)) && mapForS.get(s.charAt(start))<mapForT.get(s.charAt(start)) )
                {
                    formed--;


                }
                if(mapForS.get(s.charAt(start))==0)
                {
                    mapForS.remove(s.charAt(start));
                }

                start++;

            }
            end++;

        }
        return result;



    }

    //Input: s = "ADOBECODEBANC", t = "ABC"
    //Output: "BANC"
    //Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
}
