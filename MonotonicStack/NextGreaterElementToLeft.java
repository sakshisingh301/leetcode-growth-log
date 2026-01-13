import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementToLeft {


    public static int [] nextGreaterElementToTheLeft(int [] nums)
    {
        Stack<Integer> stack=new Stack<>();
        int [] res=new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            if(stack.isEmpty())
            {
                res[i]=-1;
            }
            else {
                while (!stack.isEmpty() && stack.peek()<nums[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    res[i]=-1;
                }
                else {
                    res[i]=stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return res;

    }
    //code for next element greater to the right
    public static int[] nextGreaterToTheRight(int [] nums)
    {

        Stack<Integer> stack=new Stack<>();
        int [] res=new int[nums.length];


        for(int i=nums.length-1;i>=0;i++)
        {
            int curr=nums[i];
            if(stack.isEmpty())
            {
             res[i]=-1;
            }
            else {
                while(!stack.isEmpty() && stack.peek()<=curr)
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    res[i]=-1;
                }
                else {
                    res[i]=stack.peek();

                }

            }
            stack.push(curr);
        }
        return res;

    }

    public static void main(String[] args) {

        int [] nums={1,3,2,4};

//        int [] nums={2,1,5,6,2,3};
        System.out.println(nextGreaterElementToTheLeft(nums));
        //{-1,2,-1,-1,6,6}

    }
}
