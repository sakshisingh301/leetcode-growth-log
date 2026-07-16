package ShortestPathDijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    //A greedy search algorithm that finds the shortest path from the single source to the other sources and weights are different
    // ex

    public int[] dijkstra(int V, int[][] edges, int src) {
        //min heap with (Distance, that Node)
        //So we are creating a distance array and maintaining the minimum distance

        //create Adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }

        //min heap
        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] minimumDistance = new int[V];

        //put the origin in the min heap
        min_heap.add(new int[]{0, src});
        //assign distance array with max value
        Arrays.fill(minimumDistance, Integer.MAX_VALUE);
        //fill src with 0
        minimumDistance[src] = 0;

        //start traversing
        while (!min_heap.isEmpty()) {
            int[] curr = min_heap.poll();
            int dist = curr[0];
            int node = curr[1];
            //iterate through the neighbour
            for (int[] neighborInfo : adj.get(node)) {
                {
                    int neighbour = neighborInfo[0];
                    int weight = neighborInfo[1];
                    int newDistance = weight + dist;
                    if (newDistance < minimumDistance[neighbour]) {
                        minimumDistance[neighbour] = newDistance;
                        min_heap.add(new int[]{newDistance, neighbour});
                    }

                }


            }


        }
        return minimumDistance;


    }
}