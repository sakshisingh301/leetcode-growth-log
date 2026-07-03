package RomantoIntegerConversion;

public class IntegerToRoman {


    //why storing the element in a hashmap would not enough?
    //lets say i have 3789, how do i see in map which number is closest to 3789
    //So in array i am already storing numbers in decreasing order so i know which number is closer to 3789
    public static String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<values.length;)
        {
            if(num>=values[i])
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


    public static void main(String[] args) {

        //3789
        int num=3749;
        System.out.println(intToRoman(num));

    }
}
