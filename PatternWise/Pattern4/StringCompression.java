package Pattern4;

public class StringCompression {

    public static int compress(char[] chars) {

        //counting the unique letters
        //because first character will be unique always
        int count=1;
        StringBuilder stringBuilder=new StringBuilder();


        for(int i=1;i<chars.length;i++)
        {
            if(chars[i]==chars[i-1])
            {
                count++;

            }
            else {
                stringBuilder.append(chars[i]).append(count);
                count=1;
            }

        }

        return stringBuilder.length();

    }

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        System.out.println(compress(chars));

    }

    //Input: chars = ["a","a","b","b","c","c","c"]
    //Output: 6
    //Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

    //Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    //Output: 4
    //Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
}
