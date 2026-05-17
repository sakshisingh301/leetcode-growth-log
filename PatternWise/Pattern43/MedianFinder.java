package Pattern43;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    //define minheap && maxheap
    //we will store the first half in max heap and second half in minheap

    PriorityQueue<Integer> max_heap;
    PriorityQueue<Integer> min_heap;

    public MedianFinder() {
        max_heap=new PriorityQueue<>(Comparator.reverseOrder());
        min_heap=new PriorityQueue<>();


    }

    public void addNum(int num) {
        //if both heaps are empty then i simply put element in max_heap
        //if the current number is less than max_heap.peek() then put it in max_heap or else min_heap
        if(max_heap.isEmpty() || num<=max_heap.peek())
        {
            max_heap.add(num);
        }
        else {
            min_heap.add(num);
        }
        //rebalance(maxheap is allowed to have 1 more number than minheap)
        //if the element is more in maxheap then take the element from maxheap(greatest) and put it in minheap
        if(max_heap.size()>min_heap.size()+1)
        {
            min_heap.add(max_heap.poll());
        }

        if(min_heap.size()>max_heap.size())
        {
            max_heap.add(min_heap.poll());
        }


    }

    public double findMedian() {
        if((min_heap.size()+max_heap.size())%2==0)
        {
            return (max_heap.peek()+ min_heap.peek())/2.0;

        }
        return max_heap.peek();

    }

//make notes
}

//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
