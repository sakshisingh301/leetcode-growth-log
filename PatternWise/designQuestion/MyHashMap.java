package designQuestion;


//Design HashMap from the scratch
// normally in Hashmap we need three functions: put(key, value) , remove(key), get(key)
//and all the function should be done in 0(1)

//Here also we will have to implement the real hashmap where the operation happens in 0(1)

import java.util.Arrays;

//naive method is since the size of key and value is already mentioned, we can an array of that size
// and keep adding the value at key's index
public class MyHashMap {

    int [] map;

    public MyHashMap()
    {
        map =new int[1000001];
        Arrays.fill(map, -1);

    }
    //put method
    private void put(int key, int value)
    {
        map[key]=value;

    }
    //get value by key
    private int get(int key)
    {
        return map[key];

    }

    //removes the entry by key
    private void remove (int key)
    {
        map[key]=-1;


    }


//Drawback: only works when the key is integer, wastes memory, will not work for more range(in case the
    //input size increases

}
