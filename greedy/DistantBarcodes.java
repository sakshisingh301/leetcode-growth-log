import java.util.ArrayList;
import java.util.PriorityQueue;

public class DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {

        PriorityQueue<int []> max_heap=new PriorityQueue<>(
                (x, y)->y[1]-x[1]
        );

        int [] frequencyOfBarcodes=new int[10001];
        for(int i=0;i< barcodes.length;i++)
        {
            frequencyOfBarcodes[barcodes[i]]++;
        }

        for(int i=0;i<frequencyOfBarcodes.length;i++)
        {
            if(frequencyOfBarcodes[i]!=0)
            {
                max_heap.add(new int []{i,frequencyOfBarcodes[i]});
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();

        while(!max_heap.isEmpty())
        {
            int [] mostFrequent=max_heap.poll();
            int mostFrequentBarcode=mostFrequent[0];
            int mostFrequentCount=mostFrequent[1];
            if(temp.size()>=1 && temp.getLast() ==mostFrequentBarcode )
            {
                if(max_heap.isEmpty())
                {
                    return null;
                }
                int [] secondMostFrequent=max_heap.poll();
                int secondMostFrequentBarcode=secondMostFrequent[0];
                int secondMostFrequentCount=secondMostFrequent[1];
                temp.add(secondMostFrequentBarcode);
                secondMostFrequentCount--;
                if(secondMostFrequentCount>0)
                {
                    max_heap.add(new int[]{secondMostFrequentBarcode,secondMostFrequentCount});
                }

            }
            else {
                temp.add(mostFrequentBarcode);
                mostFrequentCount--;
            }
            if(mostFrequentCount>0)
            {
                max_heap.add(new int [] {mostFrequentBarcode, mostFrequentCount});
            }


        }
        int [] res=new int[barcodes.length];
        for(int i=0;i<temp.size();i++)
        {
            res[i]=temp.get(i);
        }
        return res;






    }

    //: barcodes = [1,1,1,2,2,2]
}
