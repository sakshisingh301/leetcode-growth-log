import java.util.Stack;

public class LongestvalidParanthesis {

    public static int longestValidParentheses(String s) {

        int longestLength=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        for(int i=0;i<s.length();i++)
        {
            int length=0;
            if(s.charAt(i)=='(')
            {
                stack.push(i);
            }
            else {
                stack.pop();
                if(!stack.isEmpty())
                {

                    length=i-stack.peek();
                }
                else {
                    stack.push(i);

                }
            }
            longestLength=Math.max(longestLength,length);

        }
        return longestLength;

    }

    public static void main(String[] args) {
        String s=")()())";
        System.out.println(longestValidParentheses(s));


        //())(()))

    }
}
