import java.util.ArrayList;
import java.util.List;

public class ValidGraphTree {


    public  boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        // connect u to v
        for(int [] edge: edges)
        {
            int u=edge[0];
            int v= edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] visited=new boolean[n];


           if(dfs(adj,visited,0,edges, -1))
           {
               return false;
           }

           for(int i=0;i< visited.length;i++)
           {
               if(!visited[i])
               {
                   return false;
               }
           }
        return true;

    }

    private boolean dfs(List<List<Integer>> adj, boolean[] visited, int start, int[][] edges, int parent) {


        visited[start]=true;
        for(int neighbour: adj.get(start))
        {
            if(!visited[neighbour])
            {
                if(dfs(adj,visited,neighbour,edges,start))
                {
                    return true;
                }
            }
           else if(neighbour!=parent)
            {
                return true;

            }

        }
        return false;

    }

    public static void main(String[] args) {
        int n = 5;
        int [][] edges = {{0,1},{0,2},{0,3},{1,4}};
//        System.out.println(validTree(n, edges));

        //{0->1,2,3}
        //{1->0,4}
        //{2->0}
        //{3->0}
        //{4->1}


    }

}
