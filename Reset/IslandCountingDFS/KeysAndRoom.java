package IslandCountingDFS;

import java.util.List;

public class KeysAndRoom {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                return false;
            }
        }
        return true;

    }

    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        visited[room]=true;
        for(Integer it: rooms.get(room))
        {
            if(!visited[it])
            {
                dfs(rooms,it,visited);
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
