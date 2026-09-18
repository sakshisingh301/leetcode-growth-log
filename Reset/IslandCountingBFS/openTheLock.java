package IslandCountingBFS;

import java.util.*;

public class openTheLock {

    public  int openLock(String[] deadends, String target) {

        HashSet<String> deadEndSet=new HashSet<>(Arrays.asList(deadends));
        Queue<String> pq=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        pq.add("0000");
        visited.add("0000");
        int steps=0;

        while(!pq.isEmpty())
        {
            int size=pq.size();
            for(int i=0;i<size;i++) {
                String curr = pq.poll();
                if (curr.equals(target)) {
                    return steps;
                }
                if (deadEndSet.contains(curr)) {
                    continue;

                }
                List<String> allCombination = getAllCombination(curr);
                for (String str : allCombination) {
                    if (!visited.contains(str) && !deadEndSet.contains(str)) {
                        pq.add(str);
                        visited.add(str);
                    }
                }
            }
            steps++;

        }
        return -1;

    }
    //get all the combination
    private  List<String> getAllCombination(String s)
    {
        List<String> getAllCombination=new ArrayList<>();

        for(int i=0;i<4;i++)
        {
            StringBuilder stringBuilder1=new StringBuilder(s);
            stringBuilder1.setCharAt(i, moveClockWise(s.charAt(i)));
            getAllCombination.add(stringBuilder1.toString());
            StringBuilder stringBuilder2=new StringBuilder(s);
            stringBuilder2.setCharAt(i,moveAntiClockWise(s.charAt(i)));
            getAllCombination.add(stringBuilder2.toString());

        }
        return getAllCombination;

    }



    //rotate it by clockwise
    private  char moveClockWise(char c)
    {
        if(c=='9')
        {
            return '0';
        }
        return (char) (c+1);

    }

    //rotate it by anticlockwise
    private  char moveAntiClockWise(char c)
    {
        if(c=='0')
        {
            return '9';
        }
        return (char)(c-1);
    }
    //Example 1:
    //
    //Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    //Output: 6
    //Explanation:
    //A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
    //Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
    //because the wheels of the lock become stuck after the display becomes the dead end "0102".
}
