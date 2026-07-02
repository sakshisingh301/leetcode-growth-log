package RomantoIntegerConversion;

public class LengthofLastWord {

    public int lengthOfLastWord(String s) {

        String[] words = s.split("\\s+");

        for(int i=0;i<words.length;i++)
        {
            String currWord=words[i];
            if(i==words.length-1)
            {
                return currWord.length();
            }
        }
        return 0;

    }

    //Example 1:
    //
    //Input: s = "Hello World"
    //Output: 5
    //Explanation: The last word is "World" with length 5.
    //Example 2:
    //
    //Input: s = "   fly me   to   the moon  "
    //Output: 4
    //Explanation: The last word is "moon" with length 4.
    //Example 3:
    //
    //Input: s = "luffy is still joyboy"
    //Output: 6
    //Explanation: The last word is "joyboy" with length 6.
}
