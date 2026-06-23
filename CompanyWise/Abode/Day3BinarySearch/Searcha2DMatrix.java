package Abode.Day3BinarySearch;

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row= matrix.length;
        int column=matrix[0].length;

        int start=0;
        int end=row*column-1;

        while(start<=end)
        {
            int mid=(start+end)/2;
            int curr=matrix[mid/column][mid%column];
            if(curr==target)
            {
                return true;
            }
            else if(curr<target)
            {
                start=mid+1;
            }
            else if(curr>target)
            {
                end=mid-1;
            }
        }
        return false;

    }

    //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    //Output: false
}
