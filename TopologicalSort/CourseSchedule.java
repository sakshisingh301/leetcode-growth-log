import java.util.ArrayList;
import java.util.List;


public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

      //create adj list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       // i forgot to create empty arraylist
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        //[1,0] then we do course 1 first then course 0
        // we are creating an adjacency list { courses, prerequisite}
        //[1,0]:  0 is a course and to do 0, we first have to complete 1
        for(int [] num: prerequisites)
        {
            int prerequisite=num[0];
            int course=num[1];

            adj.get(course).add(prerequisite);
        }

        boolean[] visited=new boolean[numCourses];
        boolean [] dfsPath = new boolean[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                //if dfs call returns true then there is a cycle
                if(dfs(adj,visited,i, dfsPath))
                {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start, boolean[] dfsPath) {
       // visit the node first
        visited[start]=true;
        // add it to the path of that DFS call
        dfsPath[start]=true;

        for(int neighbour: adj.get(start))
        {
            if(dfsPath[neighbour])
            {
                return true;
            }
            if(!visited[neighbour])
            {
                if(dfs(adj, visited, neighbour, dfsPath)){
                    return true;
                }
            }
        }
        dfsPath[start]=false;
        return false;

    }


    public static void main(String[] args) {
        //numCourses = 2, prerequisites = [[1,0],[0,1]]
    }
}
