/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (48.41%)
 * Total Accepted:    374K
 * Total Submissions: 772.5K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<String,List<String>>();
        
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            char[] tChar = temp.toCharArray();
            Arrays.sort(tChar);
            String key = String.valueOf(tChar);
            if (result.containsKey(key)) {
                result.get(key).add(temp);
            } else {
                result.put(key, new ArrayList<>(Arrays.asList(temp)));
            }
        }
        
        return new ArrayList<>(result.values());
        
    }
}
