package IslandCountingBFS;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //store the wordList in Hashset
        HashSet<String> wordListSet = new HashSet<>(wordList);
        if(!wordListSet.contains(endWord))
        {
            return 0;
        }
        int ladderLength=1;
        Queue<String> queue=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty())
        {
            int size= queue.size();

            for(int i=0;i<size;i++)
            {
                String curr= queue.poll();
                if(curr.equals(endWord))
                {
                    return ladderLength;
                }

                //now what are some transformations you can do with current that are present in wordListSet
                HashSet<String> transformation = generateTransformation(curr, wordListSet);
                for(String str: transformation)
                {
                    if(!visited.contains(str) && wordListSet.contains(str))
                    {
                        queue.add(str);
                        visited.add(str);
                    }

                }
            }
            ladderLength++;

        }
        return 0;

    }

    private HashSet<String> generateTransformation(String s, HashSet<String> wordListSet)
    {
        //red
        HashSet<String> transformation=new HashSet<>();
        char[] letters = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'
        };
        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            for(char letter: letters)
            {
                if(curr==letter)
                {
                    continue;
                }
                StringBuilder stringBuilder=new StringBuilder(s);
                stringBuilder.setCharAt(i,letter);
                if(wordListSet.contains(stringBuilder.toString()))
                {
                    transformation.add(stringBuilder.toString());
                }

            }

        }
        return transformation;
    }

    //Example 1:
    //
    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    //Output: 5
    //Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
}
