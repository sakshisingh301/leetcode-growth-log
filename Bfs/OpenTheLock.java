import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {

        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        if(deadEnds.contains("0000")) return -1;
        Queue<String> queue=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        queue.add("0000");
        visited.add("0000");
        int steps=0;

        while(!queue.isEmpty())
        {
            int size=queue.size();
            while (size-->0)
            {
                String curr=queue.poll();
                if(curr!=null && curr.equals(target)) return steps;
                if(deadEnds.contains(curr))
                {
                    continue;
                }
               List<String> getAllPairs=allPairs(curr);
                for(String s: getAllPairs)
                {
                    if(!visited.contains(s)  && !deadEnds.contains(s))
                    {
                        visited.add(s);
                        queue.add(s);
                    }
                }

            }
            steps++;
        }
        return -1;



    }

    public List<String> allPairs(String s)
    {
        List<String> res=new ArrayList<>();

        for(int i=0;i<4;i++)
        {
            StringBuilder stringBuilder1=new StringBuilder(s);
            stringBuilder1.setCharAt(i,moveClockWise(s.charAt(i)));
            res.add(stringBuilder1.toString());
            StringBuilder stringBuilder2=new StringBuilder(s);
            stringBuilder2.setCharAt(i,moveAntiClockWise(s.charAt(i)));
            res.add(stringBuilder2.toString());

        }
        return res;
    }

    public char moveClockWise(char s)
    {
        if(s=='9')
        {
            return '0';
        }
        else {
            return (char) (s+1);
        }

    }

    public char moveAntiClockWise(char s)
    {
        if(s=='0')
        {
            return '9';
        }
        else {
            return (char) (s-1);
        }

    }




    public static void main(String[] args) {
        //deadends = ["0201","0101","0102","1212","2002"], target = "0202"

    }
}
