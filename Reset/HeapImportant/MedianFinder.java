package HeapImportant;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

   //Define a maxheap and minheap
    //start putting the element into heap and rearrange them in a way that it behaves like a max and min heap

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());


    }

    public void addNum(int num) {
        //if the maxheap is empty then simply add the num to the maxheap
        //we are trying to place the first half of the list to maxheap and second half to the minheap
        //if the num is lesser than the maxHeap.peek() then place it in the maxHeap else put it in minheap
        //if the size of minheap and maxheap differ by more than 1 then rebalance it by placing th max element from the maxHeap to minheap
        //if the size of minheap is lets say 2 and size of maxHeap is 0 then rebalance it by placing the minimum element
        //from the minheap to max heap

        if(maxHeap.isEmpty())
        {
            maxHeap.add(num);
        }
        else if(num< maxHeap.peek())
        {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }

        //if the size of minheap and maxheap is more than 1 then rebalance it
        if(Math.abs(minHeap.size()-maxHeap.size())>1)
        {
            if(minHeap.size()>maxHeap.size())
            {
                int min=minHeap.poll();
                maxHeap.add(min);
            }
            else if(maxHeap.size()>minHeap.size())
            {
                int max= maxHeap.poll();
                minHeap.add(max);
            }
        }


    }


    //polling the element from the heap log(n)
    public double findMedian() {
        double median =0.0;

        if(!minHeap.isEmpty()|| !maxHeap.isEmpty())
        {
            if(minHeap.size()>maxHeap.size())
            {
                median=minHeap.peek();
                return median;
            }
            else if (maxHeap.size()>minHeap.size())
            {
                median=maxHeap.peek();
                return median;
            }
            else {

                    double first = minHeap.peek();
                    double second = maxHeap.peek();
                    return (first + second) / 2;

            }
        }
        return median;

    }

    //["MedianFinder","addNum","findMedian"]
    //[[],[1],[]]
    //
    //Use Testcase
    //Output
    //[null,null,0.00000]
    //Expected
    //[null,null,1.00000]
}
