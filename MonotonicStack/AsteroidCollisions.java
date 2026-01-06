import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class AsteroidCollisions {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<asteroids.length;i++)
        {
            int curr=asteroids[i];
            boolean destroyed=false;

            //there will only be collision when stack.peek is positive and curr is negative which means they are
            //travelling in opposite direction
            while (!stack.isEmpty() && stack.peek()>0 && curr<0)
            {
                if(stack.peek()<Math.abs(curr))
                {
                    stack.pop();
                }
                //destroy both ex-[6,-6] , equal magnitude but opposite direction so both will be destroyed
                else if(stack.peek()==Math.abs(curr))
                {
                    //when both will be destroyed , we will have to make sure we are not pushing the curr
                    //ex- [6,-6]
                    //push 6
                    //curr now- (-6)
                    //both will be destroyed and -6 will not be added
                    destroyed=true;
                    stack.pop();
                    break;
                }
                else {
                    destroyed=true;
                   break;
                }

            }
            if(!destroyed)
            {
                stack.push(curr);
            }


        }
        ArrayList<Integer> list=new ArrayList<>();
        int [] res=new int[stack.size()];


        while(!stack.isEmpty())
        {
           list.add(stack.pop());

        }
        Collections.reverse(list);

        for(int i=0;i<list.size();i++)
        {
            res[i]= list.get(i);

        }
        return res;


    }

    public static void main(String[] args) {

        //Input
        //asteroids =
        //[10,2,-5]
        //Output
        //[10,-5]
        //Expected
        //[10]
        int [] res={10,2,-5};
        //{8,-8}
        //[5,10,-5]
        System.out.println(asteroidCollision(res));


    }
    //5,10,-5]
    //[10,2,-5]
}
