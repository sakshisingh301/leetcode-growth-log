package Design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue;
    int windowSize;

    public MovingAverage(int size) {
        queue=new LinkedList<>();
        windowSize=size;


    }

    public double next(int val) {
        queue.add(val);
        if(queue.size()>windowSize)
        {
            queue.poll();
        }
        double sum=0;
        for(Integer q: queue)
        {
            sum=sum+q;

        }
        return sum/queue.size();

    }

    //Input
    //["MovingAverage", "next", "next", "next", "next"]
    //[[3], [1], [10], [3], [5]]
    //Output
    //[null, 1.0, 5.5, 4.66667, 6.0]
    //
    //Explanation
    //MovingAverage movingAverage = new MovingAverage(3);
    //movingAverage.next(1); // return 1.0 = 1 / 1
    //movingAverage.next(10); // return 5.5 = (1 + 10) / 2
    //movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
    //movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
}
