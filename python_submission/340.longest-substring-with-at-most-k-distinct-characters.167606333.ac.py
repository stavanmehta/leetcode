class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        longest = 0
        start = 0
        chars = {} # key =c, value = last_index
        for i, c in enumerate(s):
            chars[c] = i
            if len(chars) > k:
                front = min(chars, key=chars.get) # get key of front 
                start = chars.pop(front) + 1
            longest = max(longest, i-start+1) # update longest
        return longest
