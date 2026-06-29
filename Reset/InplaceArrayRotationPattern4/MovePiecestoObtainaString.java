package InplaceArrayRotationPattern4;

public class MovePiecestoObtainaString {
    //if start==target already then return target
    //if the number of L and R are not same in start && target
    // then no matter how much you move, you will never be able to reach target( its not the end case though)
    //
    public boolean canChange(String start, String target) {

        //check 1
        if(start.equals(target))
        {
            return true;
        }
        //check if the String is same after removing _
        StringBuilder stringBuilderStart=new StringBuilder();
        StringBuilder stringBuilderTarget=new StringBuilder();
        int i=0;
        int j=0;

        while(i<start.length() && j<target.length())
        {

            if(start.charAt(i)!='_') {
                stringBuilderStart.append(start.charAt(i));
            }
            i++;
           if(target.charAt(j)!='_') {
                stringBuilderTarget.append(target.charAt(j));

            }
           j++;
        }
        if(!stringBuilderStart.toString().equals(stringBuilderTarget.toString()))
        {
            return false;
        }
        //go through the start string, for L check if target index<curr index(start string)
        //for R go through the start and check if the target index>curr index(start index)
        //L can only move to the left and R can only towards the right
        i=0;
        j=0;

        while(i<start.length() && j<target.length())
        {
            while(i<start.length() &&start.charAt(i)=='_')
            {
                i++;
            }

            while(j<target.length() &&target.charAt(j) =='_')
            {
                j++;
            }
            if(i<start.length() && j<target.length())
            {
                if(start.charAt(i)=='L' && j>i)
                {
                    return false;
                }
                if(start.charAt(i)=='R' && j<i)
                {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;

    }

    //Input: start = "_L__R__R_", target = "L______RR"
    //Output: true
}
