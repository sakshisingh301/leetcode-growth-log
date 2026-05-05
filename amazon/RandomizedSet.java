import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
        return false;

    }

    public boolean remove(int val) {
       if(!map.containsKey(val))
       {
           return false;
       }
       //index of the remove from map
       int indexOfTheRemove=map.get(val);

       //move the last element of the array to the index of removal
        int lastElement=list.get(list.size()-1);

        list.set(indexOfTheRemove,lastElement);
        //update the map with the correct indexes
        map.put(lastElement,indexOfTheRemove);
        list.remove(list.size()-1);
        map.remove(val);

       return true;

    }

    public int getRandom() {
        if(!list.isEmpty()) {
            int randIndex = random.nextInt(list.size());
            return list.get(randIndex);
        }
        return 0;

    }
}


//initial thought was to use a list to insert and remove but insert is 0(1) but removal is not and also getting
// a random value from list is also 0(n)

// combination of hashmap and list
//for insert keep adding in both the list as well as map
//for removal first find the index of the removal from the map and then set the last element in the list to that particular


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */