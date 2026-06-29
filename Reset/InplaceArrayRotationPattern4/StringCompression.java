package InplaceArrayRotationPattern4;

public class StringCompression {


//hint: How do you know if you are at the end of a consecutive group of characters?
    public static int compress(char[] chars) {


        int i=1;
        int k=0;
        int start=0;

        while(i<chars.length)
        {
            //when the adjacent character is different then we know we have found the new character and add the character and its count
            if(chars[i]!=chars[i-1])
            {
                chars[k]=chars[i-1];
                k++;
                int length=i-start;
                if(length>1)
                {
                    String string=String.valueOf(length);
                    for(int j=0;j<string.length();j++)
                    {
                        chars[k]=string.charAt(j);
                        k++;
                    }

                }
                start=i;
            }
            i++;

        }
        //putting the last group
        chars[k]=chars[i-1];
        k++;
        int length=i-start;
        if(length>1)
        {
            String string=String.valueOf(length);
            for(int j=0;j<string.length();j++)
            {
                chars[k]=string.charAt(j);
                k++;
            }
        }
        return k;

    }

    public static void main(String[] args) {
        char [] chars=new char[]{'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));

    }

    //Input: chars = ["a","a","b","b","c","c","c"]
    //Output: 6
    //Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    //After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].
}
