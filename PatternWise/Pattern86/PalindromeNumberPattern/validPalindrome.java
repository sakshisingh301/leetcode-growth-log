package Pattern86.PalindromeNumberPattern;

public class validPalindrome {

    public boolean ispalindrome(String s)
    {
        //convert all the letters into lowercase && remove non alphanumeric character(other than character from a to z))
        //removing non alpha numerical characters
        String removedNonAlphanumericCharacterFromString=s.replaceAll("[^a-zA-Z0-9]", "");
        String str=removedNonAlphanumericCharacterFromString.toLowerCase();

        int start=0;
        int end=str.length()-1;

        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }


}
//s = "A man, a plan, a canal: Panama"