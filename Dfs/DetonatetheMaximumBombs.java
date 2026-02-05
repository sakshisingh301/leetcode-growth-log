public class DetonatetheMaximumBombs {

    public  int maximumDetonation(int[][] bombs) {
        int max_detonation=0;


        for(int i=0;i<bombs.length;i++)
        {
            boolean [] visitedBomb=new boolean[bombs.length];
            int detonation=dfs(bombs,i, visitedBomb);
            max_detonation=Math.max(max_detonation,detonation);


        }
        return max_detonation;


    }

    private  int dfs(int[][]bombs, int currBomb, boolean[] visitedBomb)
    {
        visitedBomb[currBomb]=true;
        int count=1;
        for(int next=0;next<bombs.length;next++)
        {
            if(!visitedBomb[next] && canDetonate(bombs[currBomb],bombs[next]))
            {
                count=count+dfs(bombs,next,visitedBomb);
            }
        }
        return count;
    }

    private  boolean canDetonate(int [] a, int []b)
    {
        long x1= b[0]-a[0];
        long x2=b[1]-a[1];
        long r=a[2];
        return x1*x1+x2*x2<r*r;

    }


    public static void main(String[] args) {

        //Input: bombs = [[2,1,3],[6,1,4]]

    }
}
