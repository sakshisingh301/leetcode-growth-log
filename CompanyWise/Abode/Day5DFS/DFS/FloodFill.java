package Abode.Day5DFS.DFS;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int row=image.length;
        int column=image[0].length;
        boolean[][] visited=new boolean[row][column];
        if(image[sr][sc]==color)
        {
            return image;
        }
        int main_color=image[sr][sc];

        dfs(image, sr, sc, color, main_color, visited);
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int color, int mainColor,boolean [] [] visited) {
        if(sr<0 ||sc<0|| sr>=image.length || sc>=image[0].length || image[sr][sc]!=mainColor|| visited[sr][sc])
        {
            return;
        }

        visited[sr][sc]=true;
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,mainColor, visited);
        dfs(image,sr-1,sc,color,mainColor, visited);
        dfs(image,sr,sc+1,color,mainColor, visited);
        dfs(image,sr,sc-1,color,mainColor, visited);


    }

    //Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
    //
    //Output: [[2,2,2],[2,2,0],[2,0,1]]
}
