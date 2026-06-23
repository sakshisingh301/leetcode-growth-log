package Abode.Day2;

import java.util.HashMap;

public class FruitintoBasket {

    public static int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map=new HashMap<>();
        int start=0;
        int end=0;
        int totalFruits=0;


        while (end<fruits.length)
        {
            int curr=fruits[end];
            map.put(curr,map.getOrDefault(curr,0)+1);
            while (map.size()>2)
            {
                map.put(fruits[start],map.get(fruits[start])-1);
                if(map.get(fruits[start])==0)
                {
                    map.remove(fruits[start]);
                }
                start++;

            }
            int NumOfFruits=end-start+1;
            totalFruits=Math.max(totalFruits,NumOfFruits);
            end++;
        }
        return totalFruits;

    }

    public static void main(String[] args) {
        int [] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));


    }
    //Example 1:
    //
    //Input: fruits = [1,2,1]
    //Output: 3
    //Explanation: We can pick from all 3 trees.
    //Example 2:
    //
    //Input: fruits = [0,1,2,2]
    //Output: 3
    //Explanation: We can pick from trees [1,2,2].
    //If we had started at the first tree, we would only pick from trees [0,1].
    //Example 3:
    //
    //Input: fruits = [1,2,3,2,2]
    //Output: 4
}
