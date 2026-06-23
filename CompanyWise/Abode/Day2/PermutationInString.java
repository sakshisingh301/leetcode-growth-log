package Abode.Day2;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int [] freqS1=new int[26];
        //put frequency of s1
        for(Character c: s1.toCharArray())
        {
            freqS1[c-'a']++;
        }

        int [] freqS2=new int[26];
        //put the first substring of s2 which will be equal to length of s1
        for(int i=0;i<s1.length();i++)
        {
            freqS2[s2.charAt(i)-'a']++;
        }

        int count=0;
        for(int i=0;i<26;i++)
        {
            if(freqS1[i]==freqS2[i])
            {
                count++;
            }
        }

        for (int i=0;i<s2.length()-s1.length();i++)
        {
            if(count==26) return true;


            int indexOfOldChar=s2.charAt(i)-'a';
            int indexOfNewChar=s2.charAt(i+s1.length())-'a';
            //remove the old character
            freqS2[indexOfOldChar]--;
            if(freqS1[indexOfOldChar]==freqS2[indexOfOldChar])
            {
                count++;
            }
            else if(freqS2[indexOfOldChar]+1==freqS1[indexOfOldChar])
            {
                count--;
            }

            //add the new character
            freqS2[indexOfNewChar]++;
            if(freqS1[indexOfNewChar]==freqS2[indexOfNewChar])
            {
                count++;
            }
            else if(freqS2[indexOfNewChar]-1==freqS1[indexOfNewChar])
            {
                count--;
            }

        }
        return count==26;

    }
    //Input: s1 = "ab", s2 = "eidbaooo"
    //Output: true
    //Explanation: s2 contains one permutation of s1 ("ba").



}
