package Abode.Day1;

import java.util.HashMap;

public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {


        HashMap<Character, Integer> map= new HashMap<>();
        for(char c: s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i))==1)
            {
                return i;
            }
        }
        return -1;

    }

    //Example 1:
    //
    //Input: s = "leetcode"
    //
    //Output: 0
    //
    //Explanation:
    //
    //The character 'l' at index 0 is the first character that does not occur at any other index.
}
