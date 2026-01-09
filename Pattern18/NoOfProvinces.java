import java.util.ArrayList;
import java.util.List;

public class NoOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        int no_of_cities= isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<no_of_cities;i++)
        {
            adj.add(new ArrayList<>());
        }

        //create adjancency list
        for(int i=0;i<no_of_cities;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int noOfProvinces=0;
        boolean[] isCityVisited=new boolean[no_of_cities];

        //go through the adjacancy list and do DFS call
        for(int i=0;i<no_of_cities;i++)
        {
            if(!isCityVisited[i])
            {
                dfs(adj,i,isCityVisited);
                noOfProvinces++;
            }

        }
        return noOfProvinces;

    }

    private void dfs(List<List<Integer>> adj, int node, boolean[] isCityVisited) {
        isCityVisited[node]=true;
       for(int neighbour: adj.get(node))
       {
           if(!isCityVisited[neighbour])
           {
               isCityVisited[neighbour]=true;
               dfs(adj,neighbour,isCityVisited);
           }
       }
    }
    //isConnected = [[1,1,0],[1,1,0],[0,0,1]]
}
