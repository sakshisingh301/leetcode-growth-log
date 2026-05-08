package Pattern86.AnagramCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> res=new HashMap<>();

        for(String curr: strs)
        {
            char[] key=curr.toCharArray();
            Arrays.sort(key);
            String sortedKeys=new String(key);
            if(!res.containsKey(sortedKeys))
            {
                res.put(sortedKeys, new ArrayList<>());

            }
            res.get(sortedKeys).add(curr);
        }

        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
       String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));

    }

    // strs = ["eat","tea","tan","ate","nat","bat"]
}
