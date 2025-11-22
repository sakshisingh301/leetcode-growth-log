import java.util.ArrayList;
import java.util.Stack;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //create adj list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());

        }

        for(int [] num: prerequisites)
        {
            int course=num[0];
            int prerequisite=num[1];

            adj.get(prerequisite).add(course);
        }

        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[numCourses];
        boolean[] path=new boolean[numCourses];
        int [] res=new int[numCourses];
        int index=0;
        for(int i=0;i<numCourses;i++ )
        {
            if(!visited[i])
            {
                if(dfs(numCourses,prerequisites,visited, path, i , stack, adj))
                {
                    return new int[0];
                }
            }

        }

        while(!stack.isEmpty())
        {
            res[index]=stack.pop();
            index++;

        }
        return res;





    }

    private boolean dfs(int numCourses, int[][] prerequisites, boolean[] visited, boolean[] path, int course, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {


        if(path[course]) return true;
        if(visited[course]) return false;
        visited[course]=true;
        path[course]=true;

        for(int neighbour: adj.get(course) )
        {
            if(path[neighbour]) return true;
            if(!visited[neighbour])
            {
                if(dfs(numCourses, prerequisites, visited, path,neighbour, stack,adj))
                {
                    return true;
                }
            }
        }
        path[course]=false;
        stack.push(course);
        return false;

    }

}
