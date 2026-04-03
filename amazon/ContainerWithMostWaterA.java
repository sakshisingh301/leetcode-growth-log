public class ContainerWithMostWaterA {


    public int maxArea(int[] height) {

        int start=0;
        int end= height.length-1;
        int maxHeight=Integer.MIN_VALUE;

        while(start<end)
        {
            int h= Math.min(height[start],height[end]);
            int w=end-start;
            int m=h*w;
            if(height[start]<height[end])
            {
                start++;
            }
            else {
                end--;
            }
            maxHeight=Math.max(maxHeight, m);

        }
        return maxHeight;



    }


    //height = [1,8,6,2,5,4,8,3,7]
}
