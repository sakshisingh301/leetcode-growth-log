package TwoPointer;

import java.util.HashSet;

public class ShortestWaytoFormString {

    public static int shortestWay(String source, String target) {
        int i=0;
        int j=0;
        int shortestWay=0;

        HashSet<Character> sourceSet=new HashSet<>();
        for(char c: source.toCharArray())
        {
            sourceSet.add(c);
        }
        for(int k=0;k<target.length();k++)
        {
            if(!sourceSet.contains(target.charAt(k)))
            {
                return -1;
            }
        }

        while(j<target.length())
        {

            while(i<source.length() && j<target.length())
            {
                if(source.charAt(i)==target.charAt(j))
                {
                    i++;
                    j++;
                }
                else {
                    i++;

                }
            }

            shortestWay++;
            i=0;

        }
        return shortestWay;

    }

    public static void main(String[] args) {
        String source = "abc", target = "acdbc";
        System.out.println(shortestWay(source, target));

        //Output: 2
        //Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".

    }
}
