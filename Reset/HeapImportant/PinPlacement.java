package HeapImportant;

import java.util.*;

public class PinPlacement {

    //### Pin Placement in Columns
    //
    //Pinterest displays pins in a fixed number of vertical columns. Pins arrive one at a time, in the given order. Each pin has an `id` and a `height`.
    //
    //For every incoming pin:
    //
    //* Place the pin in the column with the **smallest current total height**.
    //* If multiple columns have the same minimum height, choose the column with the **smallest index**.
    //* After placing a pin, increase that column's total height by the height of the pin.
    //
    //Initially, all columns have height `0`.
    //
    //Given a list of pins and the number of columns, return the pins grouped by the column in which they were placed.
    //
    //Each pin is represented as:
    //
    //`[id, height]`
    //
    //### Function Signature
    //
    //```java
    //public List<List<int[]>> getPins(List<int[]> pins, int columns)
    //```
    //
    //### Example
    //
    //**Input:**
    //
    //```text
    //pins = [
    //    [1, 200],
    //    [2, 500],
    //    [3, 400],
    //    [4, 700],
    //    [5, 100]
    //]
    //
    //columns = 3
    //```
    //
    //Initially:
    //
    //```text
    //Column 0 = 0
    //Column 1 = 0
    //Column 2 = 0
    //```
    //
    //Pins are processed in order:
    //
    //```text
    //Pin [1,200]
    //→ All columns have height 0
    //→ Choose column 0
    //→ Heights: [200, 0, 0]
    //
    //Pin [2,500]
    //→ Column 1 is shortest
    //→ Heights: [200, 500, 0]
    //
    //Pin [3,400]
    //→ Column 2 is shortest
    //→ Heights: [200, 500, 400]
    //
    //Pin [4,700]
    //→ Column 0 is shortest
    //→ Heights: [900, 500, 400]
    //
    //Pin [5,100]
    //→ Column 2 is shortest
    //→ Heights: [900, 500, 500]
    //```
    //
    //**Output:**
    //
    //```text
    //[
    //    [(1, 200), (4, 700)],
    //    [(2, 500)],
    //    [(3, 400), (5, 100)]
    //]
    //```
    //
    //The outer list represents columns `0`, `1`, and `2`, respectively.
    //
    //### Constraints / Tie-Breaking
    //
    //If multiple columns have the same total height, always select the column with the smaller index.
    //
    //For example, if:
    //
    //```text
    //Column 0 = 100
    //Column 1 = 100
    //Column 2 = 100
    //```
    //
    //the next pin must be placed in **Column 0**.
    //
    //### Follow-up
    //
    //How would you efficiently handle a very large number of columns and pins?
    //
    //For example:
    //
    //```text
    //columns = 1000
    //```
    //
    //with many columns having the same height.
    //
    //Analyze the time and space complexity of your solution.

    public List<List<int[]>> getPins(List<int[]> pins,int columns)
    {
        List<List<int[]>> result=new ArrayList<>();
        //minheap(column no, total height)
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1])
            {
                return Integer.compare(a[0],b[0]);
            }
            else
            {
                return Integer.compare(a[1],b[1]);

            }
        });
        //column no, list of pin ids && height
        HashMap<Integer,List<int[]>> map=new HashMap<>();
        int c=0;

        for(int i=0;i<pins.size();i++)
        {
            int[] pin=pins.get(i);
            int pinId=pin[0];
            int pinHeight=pin[1];
            if(minHeap.isEmpty() || minHeap.size()<columns)
            {
                minHeap.add(new int[]{c,pinHeight});
                map.put(c,new ArrayList<>());
                map.get(c).add(new int[]{pinId,pinHeight});
                c++;

            }
            else
            {

                int[] smallestHeight=minHeap.poll();
                //column, height("id": 1, "height": 200)
                int columnNumber=smallestHeight[0];
                int height=smallestHeight[1];
                map.get(columnNumber).add(new int[]{pinId,pinHeight});
                minHeap.add(new int[]{columnNumber,height+pinHeight});

            }

        }
        //

       for(int i=0;i<columns;i++)
       {
           //pins, height
           List<int[]> values=map.get(i);
          result.add(values);

       }
        return result;
    }

    //Output:
    //[
    //[(1, 200), (4, 700)],
    //[(2, 500)],
    //[(3, 400), (5, 100)]
    //]
}
