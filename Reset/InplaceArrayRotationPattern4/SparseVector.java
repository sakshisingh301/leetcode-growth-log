package InplaceArrayRotationPattern4;

import java.util.ArrayList;
import java.util.List;

class SparseVector {
//store non zero elements with index

    //A simple array-based solution checks every index,
    // so it takes O(n) time. But because the vectors are sparse,
    // most values are zero and do not contribute to the dot product.
    // So I preprocess each vector and store only the non-zero values with their original indices.
    // Then during dotProduct, I compare only those non-zero indices using two pointers.
    // This avoids scanning all the zeros and reduces the work to O(k1 + k2),
    // where k1 and k2 are the number of non-zero elements in each vector.
    List<int[]> list;
    SparseVector(int[] nums) {
        list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                list.add(new int[]{i, nums[i]});
            }
        }

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i=0;
        int j=0;
        int result=0;

        while(i<this.list.size() && j<vec.list.size())
        {

            int [] pair1= list.get(i);
            int [] pair2=vec.list.get(j);

            int index1=pair1[0];
            int index2=pair2[0];
            int nums1=pair1[1];
            int nums2=pair2[1];

            if(index1==index2 )
            {
                result=result+ nums1*nums2;
                i++;
                j++;
                //move both pointer
            }
            else if(index1<index2)
            {
                i++;
            }
            else {
                j++;
            }

        }
        return result;

    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);