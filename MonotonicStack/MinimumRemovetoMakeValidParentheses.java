import java.util.HashSet;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        //we want to mark the unbalanced string
        Stack<Integer> stack=new Stack<>();
        StringBuilder str=new StringBuilder();
        HashSet<Integer> set=new HashSet<>();

        //iterate through the string and check the unbalanced string and mark it for further removal
        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            if(curr=='(')
            {
                stack.push(i);
            }
            else if(curr==')')
            {
                if(!stack.isEmpty() && s.charAt(stack.peek())=='(' )
                {
                    stack.pop();
                }
                else
                {
                    stack.push(i);

                }
            }
        }

        while(!stack.isEmpty())
        {
            set.add(stack.pop());


        }
        for(int i=0;i<s.length();i++)
        {
            if(!set.contains(i) )
            {
                str.append(s.charAt(i));

            }

        }
        //"a)b(c)d"
        return str.toString();

    }

    public static void main(String[] args) {
        String s= "))((";
        System.out.println(minRemoveToMakeValid(s));

    }
}
