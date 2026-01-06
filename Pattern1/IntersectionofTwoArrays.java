import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arrayList=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();

        int p1=0;
        int p2=0;

        while(p1<nums1.length && p2<nums2.length)
        {
            if(nums1[p1]<nums2[p2])
            {
                p1++;
            }
            else if(nums1[p1]>nums2[p2])
            {
                p2++;
            }
            else {
                set.add(nums1[p1]);
                p1++;
                p2++;

            }
        }
        int[] result = new int[set.size()];
        int idx = 0;

        for (int num : set) {
            result[idx++] = num;
        }

        return result;



    }


    public static void main(String[] args) {
        //nums1 = [1,1,2,2], nums2 = [2,2]

    }
}
