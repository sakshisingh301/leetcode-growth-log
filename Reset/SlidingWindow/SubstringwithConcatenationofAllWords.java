package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {


// put all words in a hashmap (map) , ex: foo- 1, bar- 1
    //barfoothefoobarman
    //windowlength=6,
    //Take out word one by one and check if it is present in hashmap and length should be appropiate
    public List<Integer> findSubstring(String s, String[] words) {

        int window = 0;
        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            window = window + word.length();
        }

        int wordLength = words[0].length();

        for (int i = 0; i <= s.length() - window; i++) {

            HashMap<String, Integer> mapForS = new HashMap<>();
            int count = 0;

            for (int j = i; j < i + window; j = j + wordLength) {

                String word = s.substring(j, j + wordLength);

                if (!map.containsKey(word)) {
                    break;
                }

                mapForS.put(word, mapForS.getOrDefault(word, 0) + 1);

                if (mapForS.get(word) > map.get(word)) {
                    break;
                }

                count++;
            }

            if (count == words.length) {
                result.add(i);
            }
        }

        return result;

    }

    //Input: s = "barfoothefoobarman", words = ["foo","bar"]
    //
    //Output: [0,9]
    //
    //Explanation:
    //
    //The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
    //The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
}
