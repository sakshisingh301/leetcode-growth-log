package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack=new Stack<>();
        List<Integer> temp=new ArrayList<>();


        for(int i=0;i<asteroids.length;i++)
        {
            int curr=asteroids[i];
            if(curr>0)
            {
                stack.push(curr);
            }
            //when the curr is negative, the stack.peek() has to be positive
            while(!stack.isEmpty() && curr<0 && stack.peek()>0 )
            {
                if(Math.abs(curr)>=Math.abs(stack.peek()))
                {
                    stack.pop();
                }
               else if(stack.isEmpty())
                {
                    stack.push(curr);
                }
               else {
                   break;
                }
            }

        }

        while(!stack.isEmpty())
        {
            temp.add(stack.pop());
        }
        Collections.reverse(temp);
        int [] result=new int[temp.size()];
        for(int i=0;i<temp.size();i++)
        {
            result[i]=temp.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] asteroids = {3,5,-6,2,-1,4};
        System.out.println(asteroidCollision(asteroids));


    }

    //Input: asteroids = [5,10,-5]
    //[10,2,-5]
    //[8,-8]
    //Output: [5,10]
    //Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
}
