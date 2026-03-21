import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeState {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> safeNodes=new ArrayList<>();
        //0 (not visited),1 (still in dfs),2(safe)
        int[] states=new int[graph.length];
        //if dfs returns true
        for(int i=0;i< graph.length;i++)
        {
            if(DFS(graph, i,states))
            {
                safeNodes.add(i);
            }
        }
        return safeNodes;

    }

    private boolean DFS(int[][] graph, int node, int[] states) {
        if(states[node]==2)
        {
            return true;
        }
        if(states[node]==1)
        {
            return false;
        }
        //as soon as you come here, mark it as 1(dfs in progress)

        states[node]=1;
        for(int neighbour: graph[node])
        {
            if(!DFS(graph, neighbour,states))
            {
                return false;

            }
        }
        //if all neighbours are safe → this node is safe
        states[node]=2;
        return true;


    }


    public static void main(String[] args) {
      //  graph = [[1,2],[2,3],[5],[0],[5],[],[]]

    }
}
