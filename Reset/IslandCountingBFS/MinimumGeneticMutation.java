package IslandCountingBFS;

import java.util.*;

public class MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet=new HashSet<>(Arrays.asList(bank));

        Queue<String> queue=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        queue.add(startGene);
        visited.add(startGene);
        int minMutation=0;

        while(!queue.isEmpty())
        {
            int size=queue.size();

            for(int i=0;i<size;i++)
            {
                String curr= queue.poll();

                if(curr.equals(endGene) && bankSet.contains(curr))
                {
                    return minMutation+1;
                }
                //generate all the combination and if the string is present in the bank then put it in the queue
                List<String> getCombination=generateCombination(curr);
                for(String str:getCombination)
                {
                    if(bankSet.contains(str) && !visited.contains(str))
                    {
                        queue.add(str);
                        visited.add(str);
                    }
                }

            }
            minMutation++;
        }
        return -1;

    }

    private List<String> generateCombination(String s)
    {
        //AACCGGTT
        List<String> combination=new ArrayList<>();
        char[] genes = {'A', 'C', 'G', 'T'};

        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            for(char gene: genes)
            {
                if(gene==curr)
                {
                    continue;
                }
                StringBuilder stringBuilder=new StringBuilder(s);
                stringBuilder.setCharAt(i,gene);
                combination.add(stringBuilder.toString());


            }
        }
        return combination;

    }

    //Example 1:
    //
    //Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
    //Output: 1

    public static void main(String[] args) {

    }
}
