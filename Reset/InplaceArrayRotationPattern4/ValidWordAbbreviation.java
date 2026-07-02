package InplaceArrayRotationPattern4;

public class ValidWordAbbreviation {

    //so the idea is when you see two character which are equal, move both the pointer
    //or else if you encounter a digit, increment p2 by that count

    public static boolean validWordAbbreviation(String word, String abbr) {


        int p1=0;
        int p2=0;


        while(p1<word.length() && p2< abbr.length())
        {
            if(Character.isLetter(abbr.charAt(p2)))
            {
                if(word.charAt(p1)!=abbr.charAt(p2))
                {
                    return false;
                }
                p1++;
                p2++;

            }
            else
            {
                //check for trailing zeros
                if(abbr.charAt(p2)=='0')
                {
                    return false;
                }
                int num=0;
                while(p2<abbr.length() &&Character.isDigit(abbr.charAt(p2)))
                {
                    num=num*10+(abbr.charAt(p2)-'0');
                    p2++;
                }
                p1=p1+num;
                if(p1>word.length())
                {
                    return false;

                }

            }

        }
        return p1==word.length() && p2==abbr.length();
    }

    public static void main(String[] args) {
       String word = "hi", abbr ="hi1";
       System.out.println(validWordAbbreviation(word, abbr));

    }

    //Input: word = "a", abbr = "2"
    //i10
    //Output: true
    //Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
}
