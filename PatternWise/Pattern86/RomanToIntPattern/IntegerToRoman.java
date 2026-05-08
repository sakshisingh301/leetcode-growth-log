package Pattern86.RomanToIntPattern;

import java.util.HashMap;

public class IntegerToRoman {


    public String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<values.length;)
        {
            if(values[i]<=num)
            {
                stringBuilder.append(romans[i]);
                num=num-values[i];

            }
            else {
                i++;
            }
        }
        return stringBuilder.toString();


    }
    //3749
}
