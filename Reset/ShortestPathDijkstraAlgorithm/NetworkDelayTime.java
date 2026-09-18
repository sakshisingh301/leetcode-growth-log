package ShortestPathDijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {

        //origin=k
        List<List<int[]>> adjList=new ArrayList<>();
        for(int i=0;i<=n ;i++)
        {
            adjList.add(new ArrayList<>());
        }
        //create adjacency list
        for(int [] time: times)
        {
            int u=time[0];
            int v=time[1];
            //node and weight
            adjList.get(u).add(new int[]{v,time[2]});
        }

        //distance
        int [] minimumDistance=new int[n+1];
        Arrays.fill(minimumDistance,Integer.MAX_VALUE);

        PriorityQueue<int []> minHeap=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        //(distance, node)
        minHeap.add(new int[]{0,k});
        minimumDistance[k]=0;

        while(!minHeap.isEmpty())
        {
            int [] curr=minHeap.poll();
            int dist=curr[0];
            int node=curr[1];

            //iterate through the adjancy list to go to the other node
            for(int[] neighbourList: adjList.get(node))
            {
                int weight=neighbourList[1];
                int neighbour=neighbourList[0];
                int newDistance=dist+weight;
                if(newDistance<minimumDistance[neighbour])
                {
                    minimumDistance[neighbour]=newDistance;
                    minHeap.add(new int[]{newDistance,neighbour});
                }
            }
        }
        int networkDelayTime=Integer.MIN_VALUE;
        for(int i=1;i<minimumDistance.length;i++)
        {
            if(minimumDistance[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            networkDelayTime=Math.max(networkDelayTime,minimumDistance[i]);

        }
        return networkDelayTime;


    }
    //Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    //Output: 2
}
