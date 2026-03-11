import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid2 {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int MinimumMoves = 0;

        //iterate through the string and push ( and once you encounter ) check the top element, pop

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stack.isEmpty() && curr == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.add(curr);
            }
        }
        while(!stack.isEmpty())
        {
            stack.pop();
            MinimumMoves++;
        }
        return MinimumMoves;
    }

    //without using stack(0(1))

    public int minAddToMakeValidWithoutSpace(String s)
    {

        int minimum=0;
        int open=0;
        int close=0;

        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            if(curr=='(')
            {
                open++;
            }
            else if( open>0)
            {
                if(curr==')') {
                    open--;
                }
            }
            else
            {
                if(curr==')')
                {
                    close++;
                }
            }
        }

        while(close>0 )
        {
            close--;
            minimum++;
        }

        while (open>0)
        {
            open--;
            minimum++;
        }

        return minimum;

    }


    //Input: s = "())"
}
