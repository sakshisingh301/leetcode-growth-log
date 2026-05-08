package Pattern4;

public class SortColors {

    public void sortColors(int[] nums) {
        int [] count=new int[3];
        for(int i=0;i< nums.length;i++)
        {
            count[nums[i]]++;
        }
        int k=0;
        for(int i=0;i<3;i++)
        {
            int curr=count[i];
            while(curr>0)
            {
                nums[k]=i;
                k++;
                curr--;
            }
        }






    }
}

//nums = [2,0,2,1,1,0]
//[2,2,2]
