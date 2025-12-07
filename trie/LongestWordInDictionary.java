import java.util.Arrays;

public class LongestWordInDictionary {

    class Trie
    {
        Trie[] links=new Trie[26];
        boolean isEnd=false;

        Trie()
        {

        }

        //containsKey
        boolean containsKey(char c)
        {
            if(links[c]!=null)
            {
                return true;
            }
            return false;
        }

        void put(Trie node, char c)
        {
            links[c-'a']=node;
        }

        Trie moveToReferencedNode(char c)
        {
            return links[c-'a'];
        }

        boolean setEnd()
        {
            isEnd=true;
            return true;

        }



    }
    private Trie root = new Trie();

    public String longestWord(String[] words) {

        //Create a root node
        //sort the words
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });
        String longestWord="";

        for(int i=0;i<words.length;i++)
        {
            String word=words[i];
            if(dfs(root,word,0))
            {
                if(word.length()>longestWord.length())
                {
                    longestWord=word;

                }
            }
        }
        return longestWord;

    }

    private boolean dfs(Trie root, String word,int index) {
        if(index==word.length())
        {
            root.setEnd();
            return true;
        }

        char currentChar=word.charAt(index);
        if(index>0 && !root.isEnd)
        {
            return false;
        }
        if(!root.containsKey(currentChar))
        {
            root.put(new Trie(), currentChar);

        }
        root=root.moveToReferencedNode(currentChar);
        return dfs(root, word,index+1);

    }


    // words = ["w","wo","wor","worl","world"]


}
