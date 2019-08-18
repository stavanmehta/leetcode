class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) == 1:
            return s
        start = 0
        end = len(s)
        maxlength = 0
        longest = ""
        while(start < len(s)):
            substring = s[start:end]
            if substring == substring[::-1] and len(substring) > maxlength:
                maxlength = len(substring)
                longest = substring
            else:
                end -=1
            if start == end:
                start += 1
                end = len(s)
        return longest
