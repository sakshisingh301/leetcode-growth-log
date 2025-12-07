//import java.util.Arrays;
//
//public class LongestWordInDictionary {
//
//    class Trie
//    {
//        Trie[] links=new Trie[26];
//        boolean isEnd=false;
//
//        Trie()
//        {
//
//        }
//
//        //containsKey
//        boolean containsKey(char c)
//        {
//            if(links[c]!=null)
//            {
//                return true;
//            }
//            return false;
//        }
//
//        void put(Trie node, char c)
//        {
//            links[c-'a']=node;
//        }
//
//        Trie moveToReferencedNode(char c)
//        {
//            return links[c-'a'];
//        }
//
//        boolean setEnd()
//        {
//            isEnd=true;
//            return true;
//
//        }
//
//
//
//    }
//    private Trie root = new Trie();
//
//    public String longestWord(String[] words) {
//
//        //Create a root node
//        //sort the words
//        // iterate through each word char by char and start adding element to the tries
//        Arrays.sort(words, (a, b) -> {
//            if (a.length() != b.length())
//                return a.length() - b.length();
//            return a.compareTo(b);
//        });
//
//        for(int i=0;i<words.length;i++)
//        {
//            String word=words[i];
//
//
//        }
//
//
//
//
//
//
//
//    }
//
//    public boolean insertAndValid (String word)
//    {
//        //add the word to the trie
//        Trie node=root;
//        for(int i=0;i<word.length();i++)
//        {
//            char currentChar=word.charAt(i);
//            //if node is not present add but then is it valid?idk
//            if(!node.containsKey(currentChar))
//            {
//
//                if(!node.setEnd())
//                {
//                    return false;
//                }
//                node.put(node, currentChar);
//            }
//            node=node.moveToReferencedNode(currentChar);
//
//            //if the character is already present then prefix is potentially valid if the previous node is the ending
//
//
//
//
//
//        }
//        node.setEnd();
//        return true;
//    }
//    // words = ["w","wo","wor","worl","world"]
//
//
//}
