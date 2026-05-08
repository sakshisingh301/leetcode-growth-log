package Pattern86.AnagramCheck;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> mapForS=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            mapForS.put(s.charAt(i),mapForS.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++)
        {
            char curr=t.charAt(i);
            if(mapForS.containsKey(curr))
            {
                mapForS.put(curr, mapForS.get(curr)-1);
                if(mapForS.get(curr)==0)
                {
                    mapForS.remove(curr);
                }
            }
            else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));

    }
}
