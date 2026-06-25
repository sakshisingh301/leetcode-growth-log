package InPlaceFromEnd;

public class SortTransformedArray {

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int [] result=new int[nums.length];

        if(a>=0)
        {
            int start=0;
            int end=nums.length-1;

            int k=nums.length-1;

            while(start<=end)
            {

                int startQ=calculate(a,b,c,nums[start]);
                int endQ=calculate(a,b,c,nums[end]);
                if(startQ<=endQ)
                {

                    result[k]=endQ;
                    k--;
                    end--;
                }
                else if(startQ>endQ)
                {
                    result[k]=startQ;
                    k--;
                    start++;
                }

            }

        }
        if(a<0)
        {
            int start=0;
            int end=nums.length-1;
            int k=0;

            while(start<=end)
            {
                if(calculate(a,b,c, nums[start])<=calculate(a,b,c, nums[end]))
                {
                    result[k]=calculate(a,b,c, nums[start]);
                    k++;
                    start++;

                }
                else if(calculate(a,b,c,nums[start])>calculate(a,b,c,nums[end]))
                {
                    result[k]=calculate(a,b,c,nums[end]);
                    k++;
                    end--;
                }

            }
        }



        return result;

    }

    private static int calculate(int a, int b, int c, int x)
    {
        return a*x*x+b*x+c;

    }

    public static void main(String[] args) {
        int [] nums={-4,-2,2,4};
        int a=-1;
        int b=3;
        int c=5;
        System.out.println(sortTransformedArray(nums,a,b,c));
    }

    //Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
    //Output: [3,9,15,33]
}
