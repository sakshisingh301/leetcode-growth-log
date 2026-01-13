import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementIAgain {

    //find next greater element to the right for num2
    //we only want to return the next element greater to the right for num1 hence use hashmap
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=nums2.length-1;i>=0;i--)
        {
            int curr=nums2[i];

          if(!stack.isEmpty())
          {

              while(!stack.isEmpty() && stack.peek()<=curr)
              {
                  stack.pop();

              }
              if(!stack.isEmpty())
              {
                  map.put(curr, stack.peek());
              }
              else {
                  map.put(curr,-1);
              }

          }
          else
          {
              map.put(curr, -1);
          }
            stack.push(curr);
        }

        int [] res=new int[nums1.length];
        int index=0;

        for(int i=0;i<nums1.length;i++)
        {
            int nextGreaterElementToTheRight=map.get(nums1[i]);
            res[index]=nextGreaterElementToTheRight;
            index++;

        }
        return res;

    }

    //Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    //[3,4,-1,-1]
    //Output: [-1,3,-1]

    public static void main(String[] args) {
        int [] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println(nextGreaterElement(nums1,nums2));


    }
}
