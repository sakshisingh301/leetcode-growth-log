package Pattern86.RomanToIntPattern;

import java.util.HashMap;

public class RomanToInteger {

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int romanToInt=map.get(s.charAt(0));

        for(int i=1;i<s.length();i++)
        {
            char prev=s.charAt(i-1);
            char curr=s.charAt(i);
            if(map.get(prev)<map.get(curr))
            {
                romanToInt=romanToInt-2*map.get(prev);
            }
            romanToInt=romanToInt+map.get(curr);
        }
        return romanToInt;

    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

    }

    //s = "MCMXCIV"
}
