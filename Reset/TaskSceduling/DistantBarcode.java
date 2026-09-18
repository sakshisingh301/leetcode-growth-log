package TaskSceduling;

import java.util.*;

public class DistantBarcode {

    public static int[] rearrangeBarcodes(int[] barcodes) {

        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<int []> maxHeap= new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int i=0;i<barcodes.length;i++)
        {
            map.put(barcodes[i], map.getOrDefault(barcodes[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            int key= entry.getKey();
            int value=entry.getValue();
            maxHeap.add(new int[]{key, value});

        }
        List<Integer> arrayList=new ArrayList<>();

        while(!maxHeap.isEmpty())
        {
            int [] mostFrequent= maxHeap.poll();
            int mostFrequentNum=mostFrequent[0];
            int mostFrequentCount=mostFrequent[1];

            if(!arrayList.isEmpty() && mostFrequentNum==arrayList.getLast())
            {
                int [] secondMostFrequent=maxHeap.poll();
                if(secondMostFrequent==null)
                {
                    return null;
                }
                int secondMostNum=secondMostFrequent[0];
                int secondMostCount=secondMostFrequent[1];
                arrayList.add(secondMostNum);
                secondMostCount--;
                if(secondMostCount>0)
                {
                    maxHeap.add(new int[]{secondMostNum, secondMostCount});
                }

            }
            else {
                arrayList.add(mostFrequentNum);
                mostFrequentCount--;
            }
            if(mostFrequentCount>0)
            {
                maxHeap.add(new int[]{mostFrequentNum, mostFrequentCount});
            }

        }
        int [] res=new int[arrayList.size()];

        for(int i=0;i<arrayList.size();i++)
        {
            res[i]= arrayList.get(i);

        }
        return res;

    }

    public static void main(String[] args) {
        int [] barcodes={1,1,1,1,2,2,3,3};
        System.out.println(rearrangeBarcodes(barcodes));

    }

    //1,1,1,1,2,2,3,3
}
