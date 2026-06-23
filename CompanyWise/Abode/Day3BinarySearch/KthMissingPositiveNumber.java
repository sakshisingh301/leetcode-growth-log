package Abode.Day3BinarySearch;

public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {

        //core idea is at index 2, there has to be 2 more numbers
        //find number of missing number if number of missing number<k then we go ahead

        int start=0;
        int end = arr.length-1;

        while (start<=end)
        {
            int mid=(start+end)/2;

            int missingNumber=arr[mid]-(mid+1);

            if(missingNumber<k)
            {
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return start+k;

    }
    //arr = [2,3,4,7,11], k = 5
}
