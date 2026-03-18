import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> result=new ArrayList<>();
        boolean [] visited=new boolean[numCourses];
        boolean[] backtrack= new boolean[numCourses];
        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int []prerequisite: prerequisites)
        {
            int u=prerequisite[0];
            int v=prerequisite[1];
            adjList.get(v).add(u);

        }

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                //if there is a cycle
                if(dfs(numCourses, visited, backtrack, result, i,adjList))
                {
                    return new int[0];
                }

            }
        }
        Collections.reverse(result);
        int [] order=new int[result.size()];

        for(int i=0;i<result.size();i++)
        {
            order[i]= result.get(i);
        }
        return order;

    }

    private boolean dfs(int numCourses, boolean[] visited, boolean[] backtrack, List<Integer> result, int node, List<List<Integer>> adj) {

        if(backtrack[node])
        {
            return true;
        }
        if(visited[node])
        {
            return false;
        }
        visited[node]=true;
        backtrack[node]=true;
        for(int neighbour: adj.get(node))
        {
            if(dfs(numCourses,visited,backtrack,result,neighbour,adj))
            {
                return true;
            }
        }
        backtrack[node]=false;
        result.add(node);
        return false;

    }

    public static void main(String[] args) {
        int [] [] prerequisites = {{1,0}, {2,1}, {3,2}, {1,3}};

    }
}
