import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int end=0;
        int max=0;
        int maxFreqCount=0;
        while(end<s.length())
        {
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            maxFreqCount=Math.max(maxFreqCount,map.get(s.charAt(end)));


            if(end-start+1-maxFreqCount<=k)
            {
              max=Math.max(end-start+1,max) ;

            }
            while(end-start+1-maxFreqCount>k)
            {
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start))==0)
                    map.remove(s.charAt(start));
                start++;
            }

            end++;

        }
        return max;



    }

    public static int characterReplacementAgain(String s, int k) {

        int start=0;
        int [] count=new int[26];
        int maxFrequency=0;
        int maxLength=0;
        for(int end=0;end<s.length();end++)
        {
            count[s.charAt(end)-'A']++;
            maxFrequency=Math.max(maxFrequency,count[s.charAt(end)-'A']);
            while((end-start+1)-maxFrequency>k)
            {
                count[s.charAt(start)-'A']--;
                start++;

            }
            maxLength=Math.max(maxLength,end-start+1);

        }
        return maxLength;



    }

    public static void main(String[] args) {
        String s="BAAAB";
        int k=2;
        System.out.println(characterReplacement(s,k));

    }
}
