import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ToplogicalSortBFS {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
       //create adj list
        List<List<Integer>> adjList=new ArrayList<>();
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int [] edge: edges)
        {
            int u=edge[0];
            int v=edge[1];

            adjList.get(u).add(v);
        }

        //define indegree array
        int [] inDegree=new int[V];

        for(int i=0;i<V;i++)
        {
            for(int it: adjList.get(i))
            {
             inDegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<V;i++)
        {
            if(inDegree[i]==0)
            {
                queue.add(i);

            }
        }

        while(!queue.isEmpty())
        {
            //remove first element queue
            int curr=queue.poll();
            result.add(curr);

            for(int neighbour : adjList.get(curr))
            {
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0)
                {
                    queue.add(neighbour);
                }


            }

        }
        return result;

    }


    public static void main(String[] args) {
        //V = 6, E = 6
    int [][]edges= {{5, 0}, {5, 2}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
    System.out.println(topoSort(6,edges));

    }
}
