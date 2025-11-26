import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeNode {

//this DFS solution is giving me TLE
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes=new ArrayList<>();

        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i< graph.length;i++)
        {
            adj.add(new ArrayList<>());
        }

        //{0->{1,2} 1->{2,3} 2->{5} etc}
       for(int i=0;i< graph.length;i++)
       {
           for(int num: graph[i])
           {
               adj.get(i).add(num);

           }
       }
       boolean [] visited=new boolean[graph.length];
       boolean [] path= new boolean[graph.length];
       boolean [] isSafe=new boolean[graph.length];

       for(int i=0;i< graph.length;i++)
       {
           if(!visited[i])
           {
               Dfs(graph,adj,visited,i,path,isSafe);

           }

       }

       for(int i=0;i< graph.length;i++)
       {
           if(isSafe[i])
           {
               safeNodes.add(i);

           }
       }
       return safeNodes;

    }

    private boolean Dfs(int[][] graph, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start, boolean[] path, boolean[] isSafe) {
        if(path[start]) return true;
        if(visited[start])
        {
            if(!isSafe[start])
            {
                return true;
            }
        }
        visited[start]=true;
        path[start]=true;
        for(int neighbour: adj.get(start))
        {
            if(Dfs(graph,adj,visited,neighbour,path,isSafe))
            {
                return true;
            }
        }
        path[start]=false;
        isSafe[start]=true;
        return false;
    }





    public static void main(String[] args) {
        //graph = [[1,2],[2,3],[5],[0],[5],[],[]]
    }
}
