package Abode.Day5DFS.DFS;

public class DetonatetheMaximumBomb {

    public int maximumDetonation(int[][] bombs) {

        //go through the bombs and check how many bomb it can detonate
        int max_detonate=0;

        for(int i=0;i<bombs.length;i++)
        {
            //check how many bomb it can detonate
            boolean[] visitedBomb= new boolean[bombs.length];
            int numOfDenotation=dfs(bombs,visitedBomb,i);
            max_detonate=Math.max(max_detonate,numOfDenotation);

        }
        return max_detonate;

    }

    private int dfs(int[][] bombs, boolean[] visitedBomb, int currBomb) {

        int count=1;
        visitedBomb[currBomb]=true;
        for(int i=0;i<visitedBomb.length;i++)
        {
            if(!visitedBomb[i] && willDenote(bombs[i],bombs[currBomb]))
            {
                count=count+dfs(bombs,visitedBomb,i);
            }
        }
        return count;
    }

    private boolean willDenote(int[] nextBomb, int[] currentBomb) {

        //distance between the centers <=radius
        long x1=currentBomb[0];
        long x2=nextBomb[0];

        long y1=currentBomb[1];
        long y2=nextBomb[1];

        long r1=currentBomb[2];
        long r2=nextBomb[2];
        return x1*x2+y1*y2<=r1*r2;




    }
}

//Input: bombs = [[2,1,3],[6,1,4]]
//Output: 2
//Explanation:
//The above figure shows the positions and ranges of the 2 bombs.
//If we detonate the left bomb, the right bomb will not be affected.
//But if we detonate the right bomb, both bombs will be detonated.
//So the maximum bombs that can be detonated is max(1, 2) = 2.
