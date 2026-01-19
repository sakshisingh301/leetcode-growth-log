public class TrappingRainWater {

    public int trap(int[] height) {

        //see the pattern when the water is stored, if there is tall building at the left and
        //tall building at the right
        //see how much water it can trap min(left,right)-current_height
        // see diagram properly, i understood this question by chatgpt hint and seeing diagram again and again
        int[] max_left=new int[height.length];
        int [] max_right=new int[height.length];
        int total_trap_water=0;

        //calculate max_left by iterating from 0
        int maximum_height_left=0;
        for(int i=0;i<height.length;i++)
        {
            if(height[i]>maximum_height_left)
            {
                max_left[i]=height[i];
                maximum_height_left=max_left[i];

            }
            else {
                max_left[i]=maximum_height_left;
            }



        }

        //calculate max_right by iterating from the last
        int maximum_height_right=0;
        for(int i=height.length-1;i>=0;i--)
        {
            if(height[i]>maximum_height_right)
            {
                max_right[i]=height[i];
                maximum_height_right=max_right[i];
            }
            else {
                max_right[i]=maximum_height_right;

            }

        }

        for(int i=0;i<height.length;i++)
        {
            int curr=height[i];
            total_trap_water=total_trap_water+Math.min(max_left[i],max_right[i])-curr;

        }
        return total_trap_water;

    }


    public static void main(String[] args) {

        // height = [0,1,0,2,1,0,1,3,2,1,2,1]

    }
}
