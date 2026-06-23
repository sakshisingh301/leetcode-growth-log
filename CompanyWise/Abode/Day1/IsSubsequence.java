package Abode.Day1;

import java.util.HashSet;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {

       //Two pointer to check the subsequence
        int i=0;
        int j=0;

        while(i<s.length() && j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        if(i!=s.length())
        {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
       String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));

        //"acb"
        //t =
        //"ahbgdc"
        //

    }

    //s =
    //"acb"
    //t =
    //"ahbgdc"
    //
    //Use Testcase
    //Output
    //true
    //Expected
    //false

    //Example 1:
    //
    //Input: s = "abc", t = "ahbgdc"
    //Output: true
    //Example 2:
    //
    //Input: s = "axc", t = "ahbgdc"
    //Output: false
    //
}
