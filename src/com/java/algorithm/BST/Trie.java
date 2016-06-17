package com.java.algorithm.BST;

//import java.util.HashMap;

//208. Medium
//Implement a trie with insert, search, and startsWith methods.
//
//Note:
//You may assume that all inputs are consist of lowercase letters a-z.
public class Trie {
	class TrieNode {
	    boolean isLeaf;
	    TrieNode[] children = new TrieNode[26];;
	    // Initialize your data structure here.
	    public TrieNode() {
	       
	    }
	}

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(word.toCharArray(), 0, root);
    }
    private void insert(char[] word, int i, TrieNode node){
        if(i == word.length){
            node.isLeaf = true;
            return ;
        }
        char c = word[i];
        if(node.children[c-'a'] == null){
            TrieNode t = new TrieNode();
            node.children[c-'a'] = t;
        }
        insert(word, i+1, node.children[c-'a']);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }
    
    private boolean search(char[] word, int i, TrieNode node){
        if(i== word.length){
            return node.isLeaf;
        }
        char c = word[i];
        return (node.children[c-'a'] != null) && search(word, i+1, node.children[c-'a']);
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(prefix.toCharArray(), 0, root);
    }
    private boolean startsWith(char[] word, int i, TrieNode node){
        if(i == word.length) return true;
        char c = word[i];
        return (node.children[c-'a'] != null) && startsWith(word, i+1, node.children[c-'a']);
    }

//	solution with HashMap, which is three times slower than the array
//	class TrieNode {
//	    boolean isLeaf;
//	    char c;
//	    HashMap<Character, TrieNode> children = new HashMap();;
//	    // Initialize your data structure here.
//	    public TrieNode() {
//	       
//	    }
//	    public TrieNode(char c){
//	        this.c = c;
//	    }
//	}
//	private TrieNode root;
//
//	    public Trie() {
//	        root = new TrieNode();
//	    }
//
//	    // Inserts a word into the trie.
//	    public void insert(String word) {
//	        HashMap<Character, TrieNode> children = root.children;
//	       
//	        for(int i = 0; i< word.length(); i++){
//	            char c = word.charAt(i);
//	            TrieNode tmp;
//	            if(!children.containsKey(c)){
//	                tmp = new TrieNode(c);
//	                children.put(c, tmp);
//	            }else{
//	                tmp = children.get(c);
//	            }
//	            children = tmp.children;
//	            if(i == word.length() -1){
//	                tmp.isLeaf = true;
//	            }
//	        }
//	    }
//
//	    // Returns if the word is in the trie.
//	    public boolean search(String word) {
//	        TrieNode t = searchNode(word);
//	        if(t != null && t.isLeaf) return true;
//	        return false;
//	    }
//
//	    // Returns if there is any word in the trie
//	    // that starts with the given prefix.
//	    public boolean startsWith(String prefix) {
//	         if(searchNode(prefix) == null) return false;
//	         return true;
//	    }
//	    private TrieNode searchNode(String s){
//	        HashMap<Character, TrieNode> children = root.children;
//	        TrieNode t = null;
//	        for(int i = 0; i< s.length();i++){
//	            char c = s.charAt(i);
//	            if(children.containsKey(c)){
//	                t = children.get(c);
//	                children = t.children;
//	            }else{
//	                return null;
//	            }
//	        }
//	        return t;
//	    }
}
