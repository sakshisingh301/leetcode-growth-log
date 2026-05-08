package Pattern86.StringManipulation;

public class FindfirstOccurence {


    public static int strStr(String haystack, String needle) {

        //two pointer
        int start=0;
        int end=needle.length()-1;

        while(end<haystack.length())
        {
            String str= haystack.substring(start,end+1);
            if(isEqual(str, needle ))
            {
                return start;
            }
            start++;
            end++;
        }
        return -1;

    }

    public static boolean isEqual (String haystackSubstring, String needle)
    {
        int i=0;
        int j=0;
        while(i<haystackSubstring.length() && j<needle.length())
        {
            if(haystackSubstring.charAt(i)!=needle.charAt(j))
            {
                return false;
            }
            i++;
            j++;
        }
        return true;

    }

    //time complexity
    //getting the substring = depends on needle's length
    //for example here length =3
    //no of substring = haystack.length()-needle.length()+1 => 0(haystack.length)=> m
    // after getting no of substring, we are comparing it with the needle
    //comparison will 0(needle.length)=n
    //Total : 0(m*n)

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));


    }

    //haystack = "leetcode", needle = "leeto"
}
