import java.util.ArrayList;
import java.util.Stack;

public class TopoSortalgo {


    public int [] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //if there is a edge between u-->v then u will appear first then v
        int [] result= new int[V];
        boolean[] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V; i++)
        {
            //start with node 0, check if it is visited if not do dfs call
            if(!visited[i])
            {
                dfs(V, adj, visited, stack,i);
            }
        }
        int i=0;
        while(!stack.isEmpty())
        {
            result[i]=stack.pop();
            i++;
        }
        return result;



    }

    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack, int start) {
       //mark that node as visited
        visited[start]=true;
        for(int neighbour:adj.get(start))
        {
            //get its neighbour
            if(!visited[neighbour])
            {
                dfs(v,adj,visited,stack,neighbour);
            }
        }
        stack.push(start);
    }

    public static void main(String[] args) {
        TopoSortalgo t = new TopoSortalgo();

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] res = t.topologicalSort(V, adj);

        for (int x : res) System.out.print(x + " ");
    }
   //0 → {}
    //1 → {}
    //2 → {3}
    //3 → {1}
    //4 → {0, 1}
    //5 → {0, 2}

    //Call DFS(2)
    //   └── Call DFS(3)
    //          └── Call DFS(1)
    //          └── DFS(1 finished → return to DFS(3))
    //   └── DFS(3 finished → return to DFS(2))
    //DFS(2 finished → return to main code)
}
