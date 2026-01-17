public class MedianOfTwoSortedArrays {


    //referred https://www.youtube.com/watch?v=NTop3VTjmxk(strivers video)
    //we are using binary search to find the the median
    //very hard question , had to spent hours to understand it

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        if(n1>n2)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high=nums1.length;

        while(low<=high)
        {
            int cut1=(low+high)/2;
            int cut2=(n1+n2+1)/2-cut1;
            int left1  = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2  = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];
            //right partition
            if(left1<=right2 && left2<=right1)
            {
                //If the length is even
                if((n1+n2)%2==0)
                {
                    return (double) (Math.max(left1, left2) + Math.min(right1, right2)) /2;

                }
                //if the length of resultant array is odd
                else
                {
                    return Math.max(left1,left2);
                }

            }
            else if(left1>right2){
                high=cut1-1;
            }
            else {
                low=cut1+1;
            }


        }
        return 0.0;

    }
    // nums1 = [1,3], nums2 = [2]


}
