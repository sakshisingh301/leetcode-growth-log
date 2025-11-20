import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberofConnectedComponentsinanUndirectedGraph {

    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int [] edge: edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        boolean [] visited=new boolean[n];
        int noOfConnectedComponents=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                Bfs(adj,i,visited);
                noOfConnectedComponents++;
            }
        }
        return noOfConnectedComponents;

    }

    private void Bfs(List<List<Integer>> adj, int start, boolean[] visited) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;

        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            for(int num: adj.get(curr))
            {
                if(!visited[num])
                {
                    visited[num]=true;
                    queue.add(num);

                }


            }

        }


    }

    public static void main(String[] args) {

        //Input: n = 5, edges = [[0,1],[1,2],[3,4]]
        //0-{1}
        //1-{0,2}
        //2-{1}
        //3-{4}
        //4--{3}

    }
}
