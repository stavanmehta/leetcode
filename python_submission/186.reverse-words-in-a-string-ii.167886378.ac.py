class Solution(object):
    def reverseWords(self, str):
        """
        :type str: List[str]
        :rtype: void Do not return anything, modify str in-place instead.
        """
        start = 0
        end = len(str) - 1
        subStart = 0

        def reverse_string(start, end):
            while start < end:
                str[start], str[end] = str[end], str[start]
                start += 1
                end -= 1

        reverse_string(start, end)

        for i in range(0, end):
            if str[i] == " ":
                reverse_string(subStart, i-1)
                subStart = i + 1
        reverse_string(subStart, end)
            
