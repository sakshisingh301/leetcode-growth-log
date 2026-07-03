package Design;

import Pattern86.RomanToIntPattern.IntegerToRoman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//I thought of Hashmap. why? Because Insertion, removal is 0(1)
//Where is the problem then? getRandom(), Hashmap does not have a method to get random number.
//Use HashMap && Arraylist. ArrayList is used just to store the number and get the random number from arraylist
//There is one more problem. Lets say i have [10, 20,30], if i call remove(20) then i also need to update my arraylist
//along with hashmap. because in getRandom() now 20 should not come
//we can remove 20 from arraylist but then we need to shift 30 to the left which is again 0(n)
//so find the index of 20 in arraylist and replace it with last number and now remove the num from last index
//[10,30,20] --> [10,30]
public class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> arrayList;
    int index;
    Random rand;
    public RandomizedSet() {
        map=new HashMap<>();
        arrayList=new ArrayList<>();
        rand= new Random();

    }


    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, arrayList.size());
            arrayList.add(val);
            return true;
        }

        return false;


    }

    public boolean remove(int val) {

        if(map.containsKey(val))
        {
            //[10,20,30]
            //store last element of the arraylist
            //lastElement=30
            int lastElement=arrayList.getLast();
            //indexInArrayList=1;
            int indexInArrayList=map.get(val);
            //replace the removal index with last element
            //[10,30,30]
            arrayList.set(indexInArrayList,lastElement);

            //initially 30's index was 2 but after removal it has to be at index 1
            map.put(arrayList.getLast(),indexInArrayList);
            //remove last element [10,30]
            arrayList.removeLast();
            map.remove(val);

            return true;
        }
        return false;



    }

    public int getRandom() {
        if(!arrayList.isEmpty()) {
            int randIndex = rand.nextInt(arrayList.size());
            return arrayList.get(randIndex);
        }
        return 0;


    }
}

//Input
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//Output
//[null, true, false, true, 2, true, false, 2]
//
//Explanation
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
//randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
//randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
//randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
//randomizedSet.insert(2); // 2 was already in the set, so return false.
//randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
