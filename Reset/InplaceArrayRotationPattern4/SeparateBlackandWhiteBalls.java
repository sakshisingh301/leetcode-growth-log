package InplaceArrayRotationPattern4;

public class SeparateBlackandWhiteBalls {

    public static long minimumSteps(String s) {
        //for each 1 check how many zeros are there afterwards

        int countZeros=0;
        long minimumSteps=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                countZeros++;
            }
        }

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                minimumSteps=minimumSteps+countZeros;

            }
            else {
                countZeros--;
            }
        }
        return minimumSteps;



    }

    public static void main(String[] args) {
        String s="100";
        System.out.println(minimumSteps(s));

    }
}
//Input: s = "101"
//Output: 1
//Explanation: We can group all the black balls to the right in the following way:
//- Swap s[0] and s[1], s = "011".
//Initially, 1s are not grouped together, requiring at least 1 step to group them to the right.