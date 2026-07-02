public class HindexII {

    public int hIndex(int[] citations) {

        int start=0;
        int end=citations.length-1;

        while(start<=end)
        {
            int mid=(start+end)/2;
            //find if mid is valid?
            //When to move left ?
            //if mid is valid, it is also possible that mid-1, mid-2 etc can also be valid
            //we have to find the first valid index, hence move to the left

            int h=citations.length-mid;
            if(citations[mid]>=h)
            {
                end=mid-1;
            }
            else
            
            {
                start=mid+1;
            }
        }
        return citations.length-start;

    }

    //Input: citations = [0,1,3,5,6]
    //Output: 3
}
