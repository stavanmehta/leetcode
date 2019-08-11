/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (39.75%)
 * Total Accepted:    192.4K
 * Total Submissions: 484.1K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */
class Trie {
    
    Set<String> storeTrie;
    /** Initialize your data structure here. */
    public Trie() {
        storeTrie = new HashSet<String>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        storeTrie.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return storeTrie.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Iterator<String> it = storeTrie.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
