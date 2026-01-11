import java.util.Stack;

public class RemoveKthdDigit {

//    public static String removeKdigits(String num, int k) {
//
//        Stack<Integer> stack=new Stack<>();
//        if(num.length()==k)
//            return "0";
//        //num = "10200";
//        for(int i=0;i<num.length();i++)
//        {
//           int curr=num.charAt(i)-'0';
//           if(stack.isEmpty()||k==0)
//           {
//               stack.push(curr);
//           }
//           else {
//               if(stack.peek() >curr)
//               {
//                   stack.pop();
//                   k--;
//               }
//               stack.push(curr);
//
//           }
//
//        }
//
//
//        StringBuilder stringBuilder=new StringBuilder();
//
//        if(stack.size()==1)
//        {
//            stringBuilder.append(stack.pop());
//        }
//        while (!stack.isEmpty() )
//        {
//
//            int curr=stack.pop();
//            if(stack.isEmpty() && curr==0)
//            {
//                continue;
//            }
//            else {
//                stringBuilder.append(curr);
//            }
//
//
//        }
//        return stringBuilder.reverse().toString();
//
//
//    }

    // what was this question dude, took me 3 days to pass all the testcases

    public  static String removeKdigits(String num, int k)
    {
        Stack<Integer> stack=new Stack<>();
        if(num.length()==k)
            return "0";

        for(int i=0;i<num.length();i++)
        {
            int curr=num.charAt(i)- '0';
            while(!stack.isEmpty() && k>0 && stack.peek()>curr)
            {
                stack.pop();
                k--;
            }
            stack.push(curr);


        }

        while(k>0)
        {
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder=new StringBuilder();

        while (!stack.isEmpty())
        {
            int curr=stack.pop();
            stringBuilder.append(curr);

        }
        String result=stringBuilder.reverse().toString();
        int index=0;
        while(index<result.length() && result.charAt(index)=='0')
        {
            index++;

        }
        result=result.substring(index);


        return result.isEmpty() ?"0": result;
    }

    public static void main(String[] args) {
        //10200
         String num = "100";
        int k = 1;
        System.out.println(removeKdigits(num,k));
        //num = "10200", k = 1

    }
}
