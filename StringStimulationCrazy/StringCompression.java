public class StringCompression {

    public static int compress(char[] chars) {

        int count=0;
        int i=0;
        int j=0;
        while(i<chars.length)
        {

            char currentChar=chars[i];
            while(currentChar==chars[i])
            {
                count++;
                i++;
            }
            //update chars


        }

        return j;

    }

    public static void main(String[] args) {
        char []chars = {'a'};
        //chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
        System.out.println(compress(chars));
//        Output: 6
        //Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
        //After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].

    }
}
