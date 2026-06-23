package StringReversal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelOftheString {


    public static String reverseVowels(String s) {

        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a','e','i','o','u',
                'A','E','I','O','U'
        ));
        char [] ch=s.toCharArray();

        int start=0;
        int end=s.length()-1;

        while(start<end)
        {

            if(vowels.contains(ch[start]) && vowels.contains(ch[end]))
            {
                //reverse

                char temp=ch[start];
                ch[start]=ch[end];
                ch[end]=temp;
                start++;
                end--;
            }
            else if(vowels.contains(ch[start]) && !vowels.contains(ch[end]))
            {
                end--;
            }
            else if(!vowels.contains(ch[start]) && vowels.contains(ch[end]))
            {
                start++;
            }
            else {
                start++;
                end--;
            }

        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String s="IceCreAm";
        System.out.println(reverseVowels(s));

    }



    //Input: s = "IceCreAm"
    //
    //Output: "AceCreIm"
    //
    //Explanation:
    //
    //The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
}
