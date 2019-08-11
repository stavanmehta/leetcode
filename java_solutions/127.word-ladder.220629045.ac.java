/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (24.97%)
 * Total Accepted:    282.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        HashSet<String> wordSet = new HashSet<String>(wordList);
        Queue<String> q = new LinkedList<String>();
        // wordSet.add(endWord);
        q.add(beginWord);
        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i < size; i++) {
                String currentWord = q.poll();
                if (currentWord.equals(endWord)) return length+1;
                wordMatch(wordSet, currentWord, q);
            }
            length++;
        }
        return 0;
    }
    
    public void wordMatch(HashSet<String> wordSet, String currentWord, Queue<String> q) {
        for (int i = 0; i < currentWord.length(); i++) {
            char[] word = currentWord.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char)(j + 'a');
                if (word[i] == c)
                    continue;
                word[i] = c;
                String s = String.valueOf(word);
                if (wordSet.contains(s)) {
                    wordSet.remove(s);
                    q.offer(s);
                }
            }
        }
        return;
    }
}
