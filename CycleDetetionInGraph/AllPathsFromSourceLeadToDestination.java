import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceLeadToDestination {


    public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

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
        }

        boolean [] visited=new boolean[n];
        //start from the source
        return Dfs(source, destination,visited, adj);


    }

    private static boolean Dfs(int node, int destination, boolean[] visited, List<List<Integer>> adj) {
        if(adj.get(node).isEmpty())
        {
            if(node!=destination)
            {
                return false;
            }
            return true;

        }
        if(visited[node]) return true;
        visited[node]=true;
        for(int neighbour: adj.get(node))
        {
                if (!Dfs(neighbour, destination, visited, adj)) {
                    return false;
                }

        }
        visited[node]=false;
        return true;
    }

    public static void main(String[] args) {
      int  n = 4;
      int [][]edges = {{0,1},{0,2},{1,3},{2,3}};
      int source = 0, destination = 3;
      System.out.println(leadsToDestination(n,edges,source,destination));

    }

    }
    // n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3

