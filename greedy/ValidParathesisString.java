import java.util.Stack;

public class ValidParathesisString {

    //we keep track of indexes of  parenthesis and star
    //if we encounter right parenthesis then we check first if leftParenthesis is not empty
    //if the leftParenthesis is empty, we check if stars is not empty , we pop respective stack
    //if both of them are empty then we return false because the right parenthesis cannot be balanced
    //we check both leftParenthesis and stars stacks see if it can be balanced but how? via indexes
    //left parenthesis has to come first then star will come , if after doing that if both of the stacks are not empty
    //then we say that it cannot be balanced

    public static boolean checkValidString(String s) {

        Stack<Integer> leftParenthesis=new Stack<>();
        Stack<Integer> stars=new Stack<>();


      for(int i=0;i<s.length();i++)
      {
          char curr=s.charAt(i);
          if(curr=='(')
          {
              leftParenthesis.add(i);
          }
          else if(curr=='*')
          {
              stars.add(i);
          }
          else {
              if(!leftParenthesis.isEmpty())
              {
                  leftParenthesis.pop();
              }
              else if(!stars.isEmpty())
              {
                  stars.pop();
              }
              else {
                  return false;
              }
          }
      }

      while(!leftParenthesis.isEmpty()  && !stars.isEmpty())
      {
          if(stars.pop()<leftParenthesis.pop())
          {
              return false;
          }
      }


      return leftParenthesis.isEmpty() && stars.isEmpty();



    }

    public static void main(String[] args) {


        // s = "(*))"
        // s="())*"
        // s= "()*("
       String s ="(*)";
       System.out.println(checkValidString(s));
    }
}
