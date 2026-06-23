package Abode.Day5DFS.BFS;

import java.util.Arrays;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int costSum= Arrays.stream(cost).sum();
        int gasSum=Arrays.stream(gas).sum();
        if(gasSum<costSum)
        {
            return -1;
        }


        int total=0;
        int start=0;

        for(int i=0;i<gas.length;i++)
        {
            int required=gas[i]-cost[i];
             total=total+required;
            if(total<0)
            {
                total=0;
                start=i+1;

            }
        }
        return start;

    }

    public static void main(String[] args) {
       int[] gas = {2,3,4}, cost = {3,4,3};
       System.out.println(canCompleteCircuit(gas,cost));
        //Output: 3

    }
}
