import java.util.Stack;

public class MinimumNumberofSwapstoMaketheStringBalanced {
     //i did not understand why did we make that formula (min_swap+1)/2;
    //if we are encountering a closing braces before opening then ofcourse we will have to swap it with unbalanced
    //opening braces later
    public int minSwaps(String s) {

        int closing=0;
        int min_swap=0;

        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            if(curr=='[')
            {
                closing=closing-1;
            }
            else {
                closing=closing+1;
            }
            min_swap=Math.max(closing,min_swap);

        }
        return (min_swap+1)/2;

    }
    //this question was hard to understand
    public int minSwapsWithStack(String s) {

        Stack<Integer> stack=new Stack<>();
        int unbalanced=0;

        for(int i=0;i<s.length();i++)
        {
            int curr=s.charAt(i);
            if(curr=='[')
            {
                stack.push(curr);
            }
            else {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else {
                    unbalanced++;
                }


            }

        }
        return (unbalanced+1)/2;

    }

    public static void main(String[] args) {
        //s = "]]][[[[]"

    }
}
