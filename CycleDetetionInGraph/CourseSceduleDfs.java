import java.util.ArrayList;
import java.util.List;

public class CourseSceduleDfs {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create empty list
        //add relations
        //define one visited array
        //define one for backtracking
        //for all the node run dfs, if dfs returns true then there is a cycle
       List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());

        }

        for(int [] prerequisite: prerequisites)
        {
          int u=prerequisite[0];
          int v=prerequisite[1];
          adjList.get(v).add(u);
        }

        boolean [] visited=new boolean[numCourses];
        boolean [] backtrack=new boolean[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if (dfs(numCourses, i, visited,backtrack, adjList))
                {
                   return false;
                }

            }
        }
        return true;


    }

    private boolean dfs(int numCourses, int node, boolean[] visited, boolean[] backtrack, List<List<Integer>> adjList) {
        //break condition
        if(backtrack[node])
        {
            return true;
        }

        if(visited[node])
        {
            return false;
        }
        //mark visited node as true
        visited[node]=true;
        backtrack[node]=true;
        for(int neighbour: adjList.get(node))
        {
            if(dfs(numCourses,neighbour,visited,backtrack,adjList))
            {
                return true;
            }

        }
        backtrack[node]=false;
        return false;
    }

    public static void main(String[] args) {
      int [] [] prerequisites = {{1,0}, {2,1}, {3,2}, {1,3}};

    }
}
