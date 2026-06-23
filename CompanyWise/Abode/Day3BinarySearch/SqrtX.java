package Abode.Day3BinarySearch;

public class SqrtX {


    public static int mySqrt(int x) {

        long start=0;
        long end=x;

        while(start<=end)
        {
            long mid=(start+end)/2;
            if(mid*mid==x)
            {
                return(int) mid;
            }
            else if(mid*mid>x)
            {
                end=mid-1;
            }
            else if(mid*mid<x)
            {
                start=mid+1;
            }
        }
        return (int)start-1;

    }

    public static void main(String[] args) {
        int x=8;
        System.out.println(mySqrt(x));
    }

    //Input: x = 8
    //Output: 2
    //Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
}
