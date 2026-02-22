import java.util.HashMap;

public class PermutationinString {

    public static boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }

        int potential_start=0;
        int end=0;
        int window_length=s1.length();

        while(potential_start<=s2.length()-window_length)
        {
            if(map.containsKey(s2.charAt(potential_start)))
            {
               end=potential_start+window_length;
                HashMap<Character,Integer> map1=new HashMap<>();
               for(int i=potential_start;i<end && i<s2.length() ;i++)
               {

                   map1.put(s2.charAt(i),map1.getOrDefault(s2.charAt(i),0)+1);
               }
               if(map1.equals(map)) {
                   return true;
               }


            }
            potential_start++;
        }
        return false;

    }

    public static boolean checkInclusionAdvancedSlidingWindow(String s1, String s2) {

        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];

        // add s1 and their frequency
        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
        }

        // add s2 (first window)
        for (int i = 0; i < s1.length(); i++) {
            freqS2[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freqS1[i] == freqS2[i]) {
                count++;
            }
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26) return true;

            int index_of_newChar = s2.charAt(i + s1.length()) - 'a';
            int index_of_oldChar = s2.charAt(i) - 'a';

            // ---- Remove old character ----
            freqS2[index_of_oldChar]--;
            if (freqS1[index_of_oldChar] == freqS2[index_of_oldChar]) {
                count++; // they became equal now
            } else if (freqS2[index_of_oldChar] + 1 == freqS1[index_of_oldChar]) {
                count--; // they were equal before, now not equal
            }

            // ---- Add new character ----
            freqS2[index_of_newChar]++;
            if (freqS1[index_of_newChar] == freqS2[index_of_newChar]) {
                count++; // they became equal now
            } else if (freqS2[index_of_newChar] - 1 == freqS1[index_of_newChar]) {
                count--; // they were equal before, now not equal
            }
        }

        return count == 26;
    }


    public static boolean checkInclusionAdvanced(String s1, String s2) {
        int [] freqS1=new int[26];
        int [] freqS2=new int[26];

        for(int i=0;i<s1.length();i++)
        {
            freqS1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s1.length();i++)
        {
            freqS2[s2.charAt(i)-'a']++;
        }
        int count=0;

        for(int i=0;i<26;i++)
        {
            if(freqS1[i]==freqS2[i])
            {
                count++;

            }
        }

        for(int i=0;i<s2.length()-s1.length();i++)
        {
            if(count==26) return true;
            int oldIndex=s2.charAt(i)-'a';
            int newIndex=s2.charAt(i+s1.length())-'a';
            //remove oldindex
            freqS2[oldIndex]--;
            if(freqS1[oldIndex]==freqS2[oldIndex])
            {
                count++;
            }
            else if(freqS1[oldIndex]+1==freqS2[oldIndex]){
                count--;
            }

            //add newIndex
            freqS2[newIndex]++;
            if(freqS1[newIndex]==freqS2[newIndex])
            {
                count++;

            }
            else if(freqS2[newIndex]-1==freqS2[newIndex]) {
                count--;
            }
        }
        return count==26;



    }




    public static void main(String[] args) {

        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusionAdvancedSlidingWindow(s1,s2));

    }
}
