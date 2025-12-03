

class TrieNode
{
    TrieNode [] links=new TrieNode[26];
    boolean isEnd=false;

    TrieNode(){

    }
    public boolean containsKey(char c)
    {
        return links[c - 'a'] != null;
    }


    public void put(TrieNode node, char currentChar) {
        links[currentChar-'a']=node;

    }
    public TrieNode referenceToTheNextNode(char currentChar)
    {
        return links[currentChar-'a'];
    }
    boolean setEnd()
    {
        isEnd=true;
        return true;
    }
}

public class Trie {

    TrieNode root;


    public Trie() {
        root=new TrieNode();
    }
    //apple
    public void insert(String word) {

        TrieNode node=root;

        for(int i=0;i<word.length();i++)
        {
            char currentChar=word.charAt(i);
            //if the letter is not present then create it, this just created a new node
            // and if the node is already present then we just move to next node
            //ex- insert app, now i want to insert apple
            // a-exists so move
            // p-exists so move
            // p-exists so move
            // l- does not exist ,create it
            // e- does not exist, create it
            if(!node.containsKey(currentChar))
            {
                node.put(new TrieNode(), currentChar);
            }
            //if we want to continue, we will have to move it to the next node
            node=node.referenceToTheNextNode(currentChar);

        }
        //Once all letters are added to the tries, we will have to set end to true
        node.setEnd();

    }

    public boolean search(String word) {
        //we have inserted apple, check if apple is present
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char currentChar=word.charAt(i);
            if(!node.containsKey(currentChar))
            {
                return false;
            }
            node=node.referenceToTheNextNode(currentChar);
        }
       return node.isEnd;

    }

    public boolean startsWith(String prefix) {

        TrieNode node=root;

        for(int i=0;i<prefix.length();i++)
        {
            char currentChar=prefix.charAt(i);
            if(!node.containsKey(currentChar))
            {
                return false;
            }
            node=node.referenceToTheNextNode(currentChar);

        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */