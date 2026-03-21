import java.util.ArrayList;
import java.util.List;

public class AllPathsLeadsToDestination {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

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

       int [] states=new int[n];
        //0,1,2
        //0--> not visited, 1--> visited, 2--> safe

        for(int i=0;i<n;i++)
        {
            if(dfs(adj, n, source, destination, states))
            {
                return true;
            }
        }
        return false;

    }

    private boolean dfs(List<List<Integer>> adj, int n, int node, int destination, int [] states) {
       //adj list is empty for current node and current node == destination
        if(adj.get(node).isEmpty())
        {
            if(node==destination)
            {
                return true;
            }
            else {
                return false;
            }

        }

        if(states[node]==1)
        {
            return false;
        }
        if(states[node]==2)
        {
            return true;
        }

        //mark it as visited
        states[node]=1;
        for(int neigbour: adj.get(node))
        {
            if(!dfs(adj,n,neigbour,destination,states))
            {
                return false;
            }
        }
        //no dfs call has failed so mark it as safe
        states[node]=2;
        return true;

    }


    public static void main(String[] args) {
        //Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2

    }
}
