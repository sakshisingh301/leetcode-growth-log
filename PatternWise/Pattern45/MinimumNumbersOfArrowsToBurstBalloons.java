package Pattern45;

import java.util.Arrays;

public class MinimumNumbersOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        //sort it by start
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int minimum=1;

        int preEnd=points[0][1];

        for(int i=1;i<points.length;i++)
        {
            int currStart=points[i][0];
            int currEnd=points[i][1];

            while(preEnd<currStart)
            {
                minimum++;
                preEnd=currEnd;

            }

        }
        return minimum;

    }


    //Input: points = [[10,16],[2,8],[1,6],[7,12]]
    //Output: 2
    //Explanation: The balloons can be burst by 2 arrows:
    //- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
    //- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
}
