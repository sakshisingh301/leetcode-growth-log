public class CountAndsay {

    public static String countAndSay(int n) {

        //if(n=1) return 1;
        if(n==1)
        {
            return "1";
        }
        StringBuilder stringBuilder=new StringBuilder();

        stringBuilder.append('1');

        for(int i=2;i<=n;i++)
        {
            //get string which is already build and count
            String temp=stringBuilder.toString();
            stringBuilder.setLength(0);

            int j=0;
            while(j<temp.length())
            {
                char currentChar=temp.charAt(j);
                int count=0;
                while(j<temp.length() &&temp.charAt(j)==currentChar)
                {
                    count++;
                    j++;
                }
                stringBuilder.append(count).append(currentChar);

            }
        }
        return stringBuilder.toString();


    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));

    }

    //xample 1:
    //
    //Input: n = 4
    //
    //Output: "1211"
    //
    //Explanation:
    //
    //countAndSay(1) = "1"
    //countAndSay(2) = RLE of "1" = "11"
    //countAndSay(3) = RLE of "11" = "21"
    //countAndSay(4) = RLE of "21" = "1211"

}
