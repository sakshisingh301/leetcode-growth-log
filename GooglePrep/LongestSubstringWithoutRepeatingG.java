import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingG {

    public  static int lengthOfLongestSubstring(String s) {

        int i=0;
        int j=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int longest_string=0;

        while(j<s.length())
        {
            char curr=s.charAt(j);
            map.put(curr, map.getOrDefault(curr,0)+1);
            if(map.size()==j-i+1)
            {
                longest_string=Math.max(longest_string,j-i+1);
                j++;
            }
            else {
                while(map.size()<j-i+1)
                {
                    if(map.containsKey(s.charAt(i)))
                    {
                        map.put(s.charAt(i),map.get(s.charAt(i))-1);
                        if(map.get(s.charAt(i))==0)
                        {
                            map.remove(s.charAt(i));
                        }
                        i++;
                    }
                }
                j++;

            }


        }
        return longest_string;


    }

    public static int lengthOfLongestStringBetter(String s)
    {
        int left=0;

        int longest_String=0;
        HashSet<Character> set=new HashSet<>();

        for(int right=0;right<s.length();right++)
        {
            char curr=s.charAt(right);
            while(set.contains(s.charAt(right)))
            {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            longest_String=Math.max(longest_String,right-left+1);

        }

        return longest_String;
    }

    public static void main(String[] args) {
        String s="nfpdmpi";
        //abcabcbb
        System.out.println(lengthOfLongestStringBetter(s));

    }
    //"pwwkew"


}
