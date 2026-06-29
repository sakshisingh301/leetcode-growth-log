package InplaceArrayRotationPattern4;


//problem similar to move pieces to Obtain a String
public class SwapAdjacentinLRString {

    public static boolean canTransform(String start, String result) {

        //XL->LX
        //RX->XR
        //Check if start is already equal to result then we do not need to transform right?
        if(start.equals(result))
        {
            return true;
        }
        if(start.length() == 1 && result.length() == 1)
        {
            return false;
        }
        //check if the length is equal for start and result
        if(start.length()!=result.length())
        {
            return false;
        }

        int i=0;
        int j=0;

        while (i<start.length() && j<result.length())
        {
            while(i<start.length() &&start.charAt(i)=='X')
            {
                i++;
            }
            while(j<result.length() &&result.charAt(j)=='X')
            {
                j++;
            }
            if(i<start.length() && j<result.length())
            {
                if(start.charAt(i)!=result.charAt(j))
                {
                    return false;
                }
                if(start.charAt(i)=='L' && i<j)
                {
                    return false;
                }
                if(result.charAt(j)=='R' &&i>j )
                {
                    return false;

                }
                i++;
                j++;
            }

        }
        while(i < start.length())
        {
            if(start.charAt(i) != 'X')
            {
                return false;
            }
            i++;
        }

        while(j < result.length())
        {
            if(result.charAt(j) != 'X')
            {
                return false;
            }
            j++;
        }

        return true;
        


    }

    public static void main(String[] args) {
        String start="XLLR";
        String result="LXLX";
        System.out.println(canTransform(start,result));
    }

    //Example 1:
    //
    //Input: start = "RXXLRXRXL", result = "XRLXXRRLX"
    //Output: true
    //Explanation: We can transform start to result following these steps:
    //RXXLRXRXL ->
    //XRXLRXRXL ->
    //XRLXRXRXL ->
    //XRLXXRRXL ->
    //XRLXXRRLX
}
