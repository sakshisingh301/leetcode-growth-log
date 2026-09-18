package IslandCountingBFS;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        //(bus stop, bus)
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        int minBus=0;

        for(int i=0;i<routes.length;i++)
        {
            int [] busStops=routes[i];
            for(int busStop: busStops){
                // bus stop, bus
                if(!adj.containsKey(busStop))
                {
                    adj.put(busStop, new ArrayList<>());
                    adj.get(busStop).add(i);
                }
                else {
                    adj.get(busStop).add(i);
                }
            }
        }
        Queue<Integer> queue=new LinkedList<>();
       boolean [] visitedBus=new boolean[routes.length];
        HashSet<Integer> visitedStop=new HashSet<>();
        //add first stop
        queue.add(source);
        visitedStop.add(source);

        while(!queue.isEmpty())
        {
            int levelSize= queue.size();
            for(int i=0;i<levelSize;i++)
            {
                //1
                int currentStop=queue.poll();
                ////find out all the bus
                for(int bus: adj.get(currentStop))
                {
                    if(visitedBus[bus])
                    {
                        continue;
                    }

                    visitedBus[bus]=true;
                    //find out all the stop related to that bus
                    //take stops from routes
                    for(int nextStops: routes[bus])
                    {
                        if(nextStops==target)
                        {
                            return minBus+1;
                        }

                        if(!visitedStop.contains(nextStops))
                        {
                            visitedStop.add(nextStops);
                            queue.add(nextStops);
                        }


                    }



                }


            }
            minBus++;

        }
        return -1;
    }

    //Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
    //Output: 2
    //Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
}
