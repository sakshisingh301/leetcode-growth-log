import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {

    public static int minAddToMakeValid(String s) {

        Stack<Character> stack=new Stack<>();
        int min=0;
        stack.push('{');

        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            if(curr=='(')
            {
                stack.push(curr);
            }
            else {
                if(stack.peek()=='{'|| stack.peek()==')')
                {
                    stack.push(curr);
                }
                else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty())
        {
            if(stack.pop()!='{')
            {
                min++;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));


    }


}
