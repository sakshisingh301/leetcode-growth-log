import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReachableNodesWithRestrictions {

    //start dfs from node 0 to n and only count those node which fall into restricted set will not be counted
    //ex- from 0 to 4 and 5 will not be counted
    //0 → [1,4,5]
    //1 → [0,2,3]
    //2 → [1]
    //3 → [1]
    //4 → [0]
    //5 → [0,6]
    //6 → [5]

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        List<List<Integer>> adj=new ArrayList<>();
        boolean [] visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int [] neighbour: edges)
        {
            int u=neighbour[0];
            int v=neighbour[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        HashSet<Integer> restrictedSet=new HashSet<>();


        for(int i=0;i< restricted.length;i++)
        {
            restrictedSet.add(restricted[i]);
        }

       // we start from node 0 and we keep visiting its neighbour so the node will automatically change
       return Dfs(n,edges,adj, visited,restrictedSet,0);




    }

    private int Dfs(int n, int [][] edges, List<List<Integer>> adj, boolean [] visited, HashSet<Integer> restrictedNode, int start )
    {
        if(restrictedNode.contains(start)) return 0;
        if(visited[start]) return 0;

        visited[start]=true;
         int node=1;

         for(int neighbour: adj.get(start))
         {
             if(!visited[neighbour] && !restrictedNode.contains(neighbour))
             {
                 node=node+Dfs(n,edges,adj,visited,restrictedNode,neighbour);
             }
         }
         return node;


    }

    public static void main(String[] args) {

        // n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]

    }
}
