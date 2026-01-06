import java.util.HashSet;

public class HappyNumberagain {

    public static boolean isHappy(int n) {

        HashSet<Integer> seen=new HashSet<>();

        while(n>0)
        {
            int nextNum=getNextNum(n);
            if(nextNum==1)
                return true;//9
            if(!seen.contains(nextNum))
            {
                seen.add(nextNum);
            }
            else {
                return false;
            }
            n=nextNum;
        }
        return true;
    }

    public static int getNextNum(int n)
    {
        int nextNum=0;

        while(n>0)
        {
            int unit=n%10;
            n=n/10;
            nextNum=unit*unit+nextNum;

        }
        return nextNum;

    }

    public static boolean isHappyCycle(int n)
    {
        int slow=n;
        int fast = getNextNum(n);

        while(slow!=fast)
        {
            slow=getNextNum(slow);
            fast=getNextNum(fast);
            fast=getNextNum(fast);
        }

        if (slow==1 && fast==1)
            return true;
        return false;


    }

    public static void main(String[] args) {

        int n=19;
        System.out.println(isHappy(n));
        //n=3

    }
}
