import java.util.*;

class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    
    TrieNode(){
    	
    }
    
    TrieNode(char c){
        this.c = c;
        isLeaf = false;
    }
}

public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i=0;i<word.length();i++){
            TrieNode node = new TrieNode();
            char t = word.charAt(i);
            if(children.containsKey(t)){
                node = children.get(t);
            }else{
            		node = new TrieNode(t);
                children.put(t, node);
            }
            
            children = node.children;
            
            if(i == word.length()-1){
                
                node.isLeaf = true;
            }
        }
    }
    
    public TrieNode searchNode(String word) {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        children = root.children;
        
        TrieNode n = null;
        for(int i=0;i<word.length();i++){
            char t = word.charAt(i);
            if(children.containsKey(t)){
                 n = children.get(t);
                children = n.children;
            }else{
                return null;
            }
        }
        return n;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
	    	TrieNode t = searchNode(word);
	    	if(t!=null && t.isLeaf) {
	    		return true;
	    	}
	    	return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode n = searchNode(prefix);
        if(n!=null)
            return true;
        return false;
    }
    
    
    public static void main(String[] args) {
    		Trie trie = new Trie();
    		trie.insert("a");
    		System.out.println(trie.search("a"));
    		System.out.println(trie.startsWith("a"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */