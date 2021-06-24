class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) < 2:
            return len(s)
        longest = 0
        start = 0
        end = 0
        while(start < len(s)) and end < len(s)+1:
            substring = s[start:end]
            # print start, end
            # print substring
            if not self.does_string_has_non_repeating_chars(substring):
                start += 1
            else:
                end += 1
                if len(substring) > longest:
                    longest = len(substring)
        return longest
    def does_string_has_non_repeating_chars(self, str):
        return len(str) == len(set(list(str)))

