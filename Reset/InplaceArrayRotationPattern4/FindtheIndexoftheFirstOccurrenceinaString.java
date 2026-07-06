package InplaceArrayRotationPattern4;

public class FindtheIndexoftheFirstOccurrenceinaString {

    public int strStr(String haystack, String needle) {
        int start=0;
        int end=needle.length()-1;

        while(end<haystack.length())
        {
            String possibleAns=haystack.substring(start, end+1);
            if(isEqual(possibleAns,needle))
            {
                return start;
            }
            start++;
            end++;
        }
        return -1;

    }

    public boolean isEqual(String possibleAns, String needle)
    {
        int i=0;
        int j=0;

        while(j<needle.length())
        {
            if(possibleAns.charAt(i)!=needle.charAt(j))
            {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    //Example 1:
    //
    //Input: haystack = "sadbutsad", needle = "sad"
    //Output: 0
    //Explanation: "sad" occurs at index 0 and 6.
    //The first occurrence is at index 0, so we return 0.
}
