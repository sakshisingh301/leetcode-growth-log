package ShortestPathDijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //array to maintain the maximum probability for each node
        double [] maximumProbability=new double[n];
        //max heap to maintained (distance, node)
        PriorityQueue<double []> maxHeap=new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));
        //create adjcancy list
        List<List<double[]>> adjList=new ArrayList<>();
        for(int i=0;i< n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i< edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            double probability= succProb[i];
            //(node, probability)
            adjList.get(u).add(new double[]{v,probability});
            adjList.get(v).add(new double[]{u,probability});
        }

        //how adj list will look like
        //0 -> (1, 0.5), (2, 0.2)
        //
        //1 -> (0, 0.5), (2, 0.5)
        //
        //2 -> (1, 0.5), (0, 0.2)

        maxHeap.add(new double[]{1.0, start_node});
        Arrays.fill(maximumProbability,0.0);
        maximumProbability[start_node]=1.0;
         while(!maxHeap.isEmpty())
         {
             double [] curr=maxHeap.poll();
             double probability=curr[0];
             int node=(int)curr[1];

            for(double[] neighbourlist: adjList.get(node))
            {
                double neighbourProbability= neighbourlist[1];
                int neighbourNode=(int)neighbourlist[0];

                double newProbability=probability*neighbourProbability;

                if(newProbability>maximumProbability[neighbourNode])
                {
                    maximumProbability[neighbourNode]=newProbability;
                    maxHeap.add(new double[]{newProbability,neighbourNode});
                }
            }
         }

        return maximumProbability[end_node];


    }

    //Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
    //Output: 0.25000
    //Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
}
