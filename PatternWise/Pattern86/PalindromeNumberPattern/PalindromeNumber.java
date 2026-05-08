package Pattern86.PalindromeNumberPattern;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        //palindrome is a number if you read it from left to right && right to left it has to be equal
        //two pointer
        //there is no way you can find the length of x and we need it for end calculation, hence convert it into
        //Strings
        String number=String.valueOf(x);
        int start=0;
        int end= number.length()-1;

        while(start<end)
        {
            if(number.charAt(start)!=number.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }


    //x=121
}
