import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //create adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int [] prerequisite: prerequisites)
        {
            int u=prerequisite[0];
            int v=prerequisite[1];
            adj.get(u).add(v);
        }

        boolean[] visited=new boolean[numCourses];
        boolean [] onPath=new boolean[numCourses];


        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if(Dfs(numCourses,prerequisites,visited,i, onPath, adj));
                {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean Dfs(int numCourses, int[][] prerequisites, boolean[] visited, int course, boolean[] onPath, List<List<Integer>> adj) {

        onPath[course]=true;
        visited[course]=true;
        for(int neighbour: adj.get(course) )
        {
            if(Dfs(numCourses,prerequisites,visited,neighbour,onPath,adj))
            {
                return false;
            }
        }






        return true;
    }

    public static void main(String[] args) {
        //numCourses = 2, prerequisites = [[1,0],[0,1]]
    }
}
