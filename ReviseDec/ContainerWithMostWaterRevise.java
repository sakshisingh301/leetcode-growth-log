public class ContainerWithMostWaterRevise {
    // idea is to maximise the width and height both
    public int maxArea(int[] height) {

        int max_area=0;
        int start=0;
        int end= height.length-1;

        while (start<end)
        {
            int h=Math.min(height[start], height[end]);
            int width= end-start;
            int area=h*width;
            max_area=Math.max(area, max_area);
            if(height[start]<height[end])
            {
                start++;

            }
            else {
                end--;
            }

        }
        return max_area;


    }


    public static void main(String[] args) {
        // height = [1,8,6,2,5,4,8,3,7]

    }
}
