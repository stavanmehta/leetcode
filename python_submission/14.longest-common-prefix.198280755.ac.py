class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strs.sort(key=len)
        totalWords = len(strs)
        prefix = ""
        if not strs or strs[0] is None or strs[0] == "":
            return ""
        for i, char in enumerate(strs[0]):
            count = 0
            for word in strs:
                if word[i] == char:
                    count += 1
            if len(prefix) == i and count == totalWords:
                prefix += char
        return prefix 
