package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {

        //sort by height decending and if the height is equal then we give precedense to k having lower value
        //We try to place all the taller people first and put shorter in their places
       //desending (b,a)
        //sort by desending height if the height is equal the sort in increasing order
      Arrays.sort(people, (a,b)->{
              if(a[0]==b[0])
                  {
                      return Integer.compare(a[1],b[1]);

                  } else {
                  return Integer.compare(b[0],a[0]);

              }
      });
        List<int[]> result=new ArrayList<>();

        for(int i=0;i< people.length;i++)
        {
            int index=people[i][1];
            result.add(index, people[i]);
        }
        return result.toArray(new int[0][]);


    }
    //Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    //Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    //Explanation:
    //Person 0 has height 5 with no other people taller or the same height in front.
    //Person 1 has height 7 with no other people taller or the same height in front.
    //Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
    //Person 3 has height 6 with one person taller or the same height in front, which is person 1.
    //Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
    //Person 5 has height 7 with one person taller or the same height in front, which is person 1.
    //Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
    //Example 2:
    //
    //Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
    //Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
}
