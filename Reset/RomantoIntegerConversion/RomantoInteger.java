package RomantoIntegerConversion;

import java.util.HashMap;

public class RomantoInteger {

    public int romanToInt(String s) {

        //only add if its in decreasing order
        //50,5,1,1,1
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=map.get(s.charAt(0));

        for(int i=1;i<s.length();i++)
        {

            sum=sum+map.get(s.charAt(i));
            if(map.get(s.charAt(i))>map.get(s.charAt(i-1)))
            {
                sum=sum-2*map.get(s.charAt(i-1));

            }


        }
        return sum;


    }
    //Symbol       Value
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000


    //Example 1:
    //
    //Input: s = "III"
    //Output: 3
    //Explanation: III = 3.
    //Example 2:
    //
    //Input: s = "LVIII"
    //Output: 58
    //Explanation: L = 50, V= 5, III = 3.
    //Example 3:
    //
    //Input: s = "MCMXCIV"
    //Output: 1994
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    //
}
