class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) < 2 or s == s[::-1]:
            return s
        start = 0
        end = 0
        longest_string = [""]
        while end < len(s):
            substring = s[start:end + 1]
            # print(substring)
            if self.is_palindrome(substring):
                longest_string.append(substring)
                # if len(longest_string) < len(substring):
                #     longest_string = substring
            end += 1
            if end == len(s):
                start += 1
                end = start + 1
        longest_string.sort(key=len)
        return longest_string.pop()

    def is_palindrome(self, s: str) -> bool:
        # print(s)
        return s == s[::-1]

if __name__ == '__main__':
    s = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" \
        "00000000000"
    print(Solution().is_palindrome(s))