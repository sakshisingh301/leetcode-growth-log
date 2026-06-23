package Abode.Day2;

public class ValidateIPAddress {

    public String validIPAddress(String queryIP) {
        String isIPV4="IPv4";
        String isIPv6="IPv6";
        String neither="Neither";
        String [] words=new String[]{};


        //break it based on the spilter --> can be : or .
        if(queryIP.contains("."))
        {
            words=queryIP.split("\\.", -1);
            //check the range of each words
            if(words.length!=4)
            {
                return neither;
            }
            if(isInRangeForIpv4(words))
            {
                return isIPV4;
            }

        }
        if(queryIP.contains(":"))
        {
            words=queryIP.split(":",-1);
            if(words.length!=8)
            {
                return neither;
            }
            for(String word: words)
            {
                if(!isHexadecimal(word))
                {
                    return neither;
                }
            }
            return isIPv6;

        }
        return neither;


    }

    private boolean isInRangeForIpv4(String [] words)
    {


        for (String word : words) {
            if (word.length() > 1 && word.charAt(0) == '0') {
                return false;
            }
            if (word.isEmpty()) {
                return false;
            }
            for(char c: word.toCharArray())
            {
                if(!Character.isDigit(c))
                {
                    return false;

                }
            }
            if (Integer.parseInt(word) > 255 || Integer.parseInt(word) < 0 ) {
                return false;
            }
        }
        return true;
    }

    private boolean isHexadecimal(String words)
    {
        if (words.isEmpty() || words.length() > 4) {
            return false;
        }
       for(char c: words.toCharArray())
       {
           if (!(Character.isDigit(c)
                   || (c >= 'a' && c <= 'f')
                   || (c >= 'A' && c <= 'F')))
           {
               return false;
           }
       }
       return true;
    }


    //Example 1:
    //
    //Input: queryIP = "172.16.254.1"
    //Output: "IPv4"
    //Explanation: This is a valid IPv4 address, return "IPv4".
    //Example 2:
    //
    //Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
    //Output: "IPv6"
    //Explanation: This is a valid IPv6 address, return "IPv6".
    //Example 3:
    //
    //Input: queryIP = "256.256.256.256"
    //Output: "Neither"
    //Explanation: This is neither a IPv4 address nor a IPv6 address.
    //
}
