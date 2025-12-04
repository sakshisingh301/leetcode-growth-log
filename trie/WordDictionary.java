
class TrieNodeForWordDictionary{

    TrieNodeForWordDictionary [] links=new TrieNodeForWordDictionary[26];
    boolean isEnd=false;

    TrieNodeForWordDictionary(){

    }

    //containsKey
    boolean containsKey(char c)
    {
        if(links[c-'a']!=null)
        {
            return true;
        }
        return false;
    }

    void put (TrieNodeForWordDictionary node, char c)
    {
        //put character in the links
        links[c-'a']=node;

    }

    TrieNodeForWordDictionary moveToTheReferencedNode(char c)
    {
        return links[c-'a'];
    }
    boolean  setEnd()
    {
        isEnd=true;
        return true;
    }

}

class WordDictionary {

    TrieNodeForWordDictionary root;

    public WordDictionary() {
        root=new TrieNodeForWordDictionary();

    }

    public void addWord(String word) {

        TrieNodeForWordDictionary node=root;

        for(int i=0;i<word.length();i++)
        {
            char currentChar=word.charAt(i);
            if(!node.containsKey(currentChar))
            {
                node.put(new TrieNodeForWordDictionary(),currentChar);

            }
            node= node.moveToTheReferencedNode(currentChar);
        }
        //set end as true
        node.setEnd();


    }

    public boolean search(String word) {
        TrieNodeForWordDictionary node=root;
        return helper(word,0,node);
    }
    //{current-"bad", "mad", "lat" search ".ad"
    // mad
    private boolean helper(String word, int index, TrieNodeForWordDictionary node) {
        if(index==word.length())
        {
           return node.isEnd;
        }
        char currentChar=word.charAt(index);
        // if the char is not . but a letter
        if(currentChar!='.')
        {
            if(!node.containsKey(currentChar))
            {
                return false;
            }
            return helper(word,index+1,node.moveToTheReferencedNode(currentChar));

        }
        //if the char is . then there will be 26 combination
        // aad,bad,cad
        for(int i=0;i<26;i++)
        {
            //aad
            TrieNodeForWordDictionary possibilities=node.links[i];
            if(possibilities!=null)
            {
                if(helper(word, index+1,possibilities))
                {
                    return true;
                }
            }



        }
        return false;
    }


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */