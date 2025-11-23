import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {

    //keep the index of last ocurrance of every letter


    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> list=new ArrayList<>();


        //store the last index of each letter
        int [] lastOccurance =new int[26];

        for(int i=0;i<s.length();i++)
        {
            lastOccurance[s.charAt(i)-'a']=i;

        }

        int start=0;
        int end=0;


        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            end=Math.max(end, lastOccurance[curr-'a']);
            if(i==end)
            {


                list.add(end-start+1);
                start=end+1;
            }

        }
        return list;

    }

    public static void main(String[] args) {
        //s = "ababcbacadefegdehijhklij"

    }
}
