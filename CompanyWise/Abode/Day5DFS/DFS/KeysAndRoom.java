package Abode.Day5DFS.DFS;

import java.util.List;

public class KeysAndRoom {
   // create a city array and start doing dfs from 0 to n-1 and once you have visited the city, mark them as visited
    //later when all the city are visited, return true
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited=new boolean[rooms.size()];

        //start dfs from city 0
        dfs(0,visited, rooms);

        //go through all the city and check if it is visited, eben if one of the city is unvisited return false

        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                return false;
            }
        }
        return true;
    }

    private void dfs(int room, boolean[] visited, List<List<Integer>> rooms) {

        visited[room]=true;
        for(Integer it:rooms.get(room))
        {
            if(!visited[it])
            {
                dfs(it,visited,rooms);
            }
        }



    }

    //Input: rooms = [[1],[2],[3],[]]
    //Output: true
    //Explanation:
    //We visit room 0 and pick up key 1.
    //We then visit room 1 and pick up key 2.
    //We then visit room 2 and pick up key 3.
    //We then visit room 3.
    //Since we were able to visit every room, we return true.
}
