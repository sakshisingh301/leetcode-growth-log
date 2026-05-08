package Pattern86.PalindromeNumberPattern;

public class ValidPalindromeIV {

    public static boolean makePalindrome(String s) {

        int start=0;
        int end=s.length()-1;
        int count=0;

        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                if(count<2)
                {
                    count++;
                    start++;
                    end--;
                }
                else {
                    return false;
                }
            }
            else {
                start++;
                end--;

            }



        }
        return true;

    }

    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(makePalindrome(s));

    }
    //s = "abcdef"
}
