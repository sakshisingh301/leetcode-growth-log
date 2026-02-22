import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) return list;

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        // Build frequency for p and first window of s
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
            freqS[s.charAt(i) - 'a']++;
        }

        // Count how many characters match
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freqP[i] == freqS[i]) {
                count++;
            }
        }

        // Slide window
        for (int i = 0; i < s.length() - p.length(); i++) {

            // If all 26 characters match → anagram found
            if (count == 26) {
                list.add(i);
            }

            int oldIndex = s.charAt(i) - 'a';
            int newIndex = s.charAt(i + p.length()) - 'a';

            // ---- Remove old character ----
            freqS[oldIndex]--;
            if (freqS[oldIndex] == freqP[oldIndex]) {
                count++;
            } else if (freqS[oldIndex] + 1 == freqP[oldIndex]) {
                count--;
            }

            // ---- Add new character ----
            freqS[newIndex]++;
            if (freqS[newIndex] == freqP[newIndex]) {
                count++;
            } else if (freqS[newIndex] - 1 == freqP[newIndex]) {
                count--;
            }
        }

        // Check last window
        if (count == 26) {
            list.add(s.length() - p.length());
        }

        return list;
    }

    public static void main(String[] args) {
      String s = "aaab";
      String p = "aab";
      System.out.println(findAnagrams(s,p));

    }
    //Input: s = "cbaebabacd", p = "abc"
    //Output: [0,6]
}
