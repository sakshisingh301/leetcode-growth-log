import java.util.*;


public class FindKPairswithSmallestSums {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result=new ArrayList<>();
        PriorityQueue<int [] > min_heap=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        min_heap.offer(new int[]{nums1[0]+nums2[0],0,0});
        Set<String> visited=new HashSet<>();
        visited.add("0,0");


        while (k>0 && !min_heap.isEmpty())
        {

            int [] temp= min_heap.poll();
            int index1=temp[1];
            int index2=temp[2];

            if(index2!=nums2.length-1)
            {
                String key = index1 + "," + (index2 + 1);

                if(!visited.contains(key) )
                {
                    min_heap.add(new int[]{nums1[index1]+nums2[index2+1], index1,index2+1});
                    visited.add(key);
                }

            }
            if(index1!=nums1.length-1)
            {
                String key = (index1 + 1) + "," + index2;

                if(!visited.contains(key) )
                {
                    min_heap.add(new int[]{nums1[index1+1]+nums2[index2], index1+1,index2});
                    visited.add(key);

                }

            }
            result.add(Arrays.asList(nums1[index1], nums2[index2]));
            k--;




        }

        return result;

    }

    public static void main(String[] args) {
       int [] nums1 = {1,7,11};
       int [] nums2 = {2,4,6};
       int k = 3;
       System.out.println(kSmallestPairs(nums1,nums2,k));
    }
}


