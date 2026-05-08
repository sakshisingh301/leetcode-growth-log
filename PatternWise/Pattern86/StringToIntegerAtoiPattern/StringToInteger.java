package Pattern86.StringToIntegerAtoiPattern;

public class StringToInteger {


    //ignore the whitespace at the start
    //if the whitespace comes after we have started reading the number then just stop
    //determine the sign and if the sign is coming once we have started parsing the integer then stop
    //if there are character (a-to -z) then immediately stop
    //keep the integer in the required range, if curr_int is greater than 2(31) - 1 then return the max value
    //if curr_int < (-2(31)) then keep it into min value
    public static int myAtoi(String s) {
        long result = 0;

        int i=0;
        int length=s.length();
        int sign =1;
        //find out the start
        while(i<length && s.charAt(i)==' ')
        {
            i++;
        }

        //find out the sign
        if(i<length && (s.charAt(i)=='+' || s.charAt(i)=='-'))
        {
            if(s.charAt(i)=='-')
            {
                sign=-1;
            }

            i++;
        }

        while(i<length && Character.isDigit(s.charAt(i)))
        {
            long digit=s.charAt(i)-'0';
            result=result*10+digit;
            if(sign* result>=Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            if(sign*result<=Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int)(sign*result);

    }
    //" -042"
    // s = "1337c0d3"
    // "   -042"
    //"+-12"

    public static void main(String[] args) {
        String s="+-12";
        System.out.println(myAtoi(s));

    }
}
