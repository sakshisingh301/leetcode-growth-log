import java.util.TreeMap;

public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        for(int i=0;i<hand.length;i++)
        {
            if(!treeMap.containsKey(hand[i]))
            {
                treeMap.put(hand[i],1);
            }
            else {
                treeMap.put(hand[i], treeMap.get(hand[i])+1);
            }
        }

       while(!treeMap.isEmpty())
       {
           int first= treeMap.firstKey();

           for(int i=0;i<groupSize;i++)
           {
               int curr=first+i;

               if(!treeMap.containsKey(curr))
               {
                   return false;
               }

               int currFrequency=treeMap.get(curr);

               if(currFrequency==1)
               {
                   treeMap.remove(curr);
               }
               else {
                   treeMap.put(curr, currFrequency-1);
               }

           }

       }
       return true;

    }

    public static void main(String[] args) {
        int [] hand = {1,2,3,4,5};
        int  groupSize = 4;
        System.out.println(isNStraightHand(hand, groupSize));


    }


}
