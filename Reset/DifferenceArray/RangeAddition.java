package DifferenceArray;

public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {

        //create a resultant array
        int [] result=new int[length];

        for(int [] update: updates)
        {
            int start=update[0];
            int end=update[1];
            int number=update[2];
            result[start]=result[start]+number;
            if(end<length-1)
            {
                result[end+1]=result[end+1]+(-1*number);
            }

        }

        //get prefix sum
        int temp=0;
        for(int i=0;i<result.length;i++)
        {
            temp=temp+result[i];
            result[i]=temp;

        }
        return result;

    }

    //Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
    //Output: [-2,0,3,5,3]
    //[-2,0,2,0,-3]
}
