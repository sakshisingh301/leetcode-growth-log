public class ZigZagConversion {


    //i was able to come up with the logic but writing clean code was pain in my ass
    public static String convert(String s, int numRows) {
       StringBuilder res=new StringBuilder();
       //if numRows==1 return s ex= s="anc" numRows==1
        //a b c
        //\  \
        if(numRows==1) return s;

        //process row 0 (i=i+increment) and last
        //for row other than 0 and last , get the diagonal index and add to the res
        //process row by row
        int increment=2*(numRows-1);
        for(int r=0;r<numRows;r++)
        {
            for(int i=r;i<s.length();i+=increment)
            {
                res.append(s.charAt(i));
                int diagIndex=i+increment-2+r;
                if(r>0 && r<numRows-1 && diagIndex<s.length())
                {
                    res.append(s.charAt(diagIndex));
                }

            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
      String s = "PAYPALISHIRING";
      int numRows = 4;
      System.out.println(convert(s,numRows));
        //Output: "PINALSIGYAHRPI"
        //Explanation:
        //P     I    N
        //A   L S  I G
        //Y A   H R
        //P     I

    }
}
