import java.util.Stack;

public class NextGreaterElementIIAgain {

    public static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack=new Stack<>();
        int [] temp=new int[nums.length];

        for(int i=nums.length-1;i>=0;i--)
        {
            stack.push(nums[i]);
        }

        for(int i=nums.length-1;i>=0;i--)
        {
            int curr=nums[i];
            while(!stack.isEmpty() && stack.peek()<=curr)
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                temp[i]=-1;
            }
            else {
                temp[i]=stack.peek();
            }

            stack.push(curr);

        }
        return temp;


    }


    public static void main(String[] args) {
        int [] nums = {5,4,3,2,1};
        System.out.println(nextGreaterElements(nums));


    }
}
