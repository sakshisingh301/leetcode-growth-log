package InPlaceFromEnd;

public class MergeSortedArray {

   //dont create a new array and return, modify num1 and by default num1 will be returned
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //start from the end
        int p1=m-1;
        int p2=n-1;
        int k=nums1.length-1;

        while(p1!=0 && p2!=0)
        {
            if(nums1[p1]<=nums2[p2])
            {
                nums1[k]=nums2[p2];
                p2--;
                k--;

            }
            else if(nums1[p1]>nums2[p2])
            {
                nums1[k]=nums1[p1];
                p1--;
                k--;
            }
        }

        while(p2>=0)
        {
            nums1[k]=nums2[p2];
            p2--;
            k--;
        }





    }

    //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //Output: [1,2,2,3,5,6]
}
