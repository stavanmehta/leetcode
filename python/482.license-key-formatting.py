class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        # s = S.replace("-", "")
        # result = list()
        # cnt1, cnt2 = 0, 0
        # for i, ch in enumerate(reversed(s)):
        #     print(cnt1)
        #     cnt1 += 1
        #     if i % K == 0 and i != 0:
        #         result.insert(0, "-")
        #     result.insert(0, ch.upper())
        # print( "".join(result))

        s = S[::-1].replace("-", "").upper()
        i, j = 0, K
        result = list()

        while j < len(s):
            result.insert(0, s[i:j][::-1])
            i = j
            j += K
        result.insert(0, s[i:j][::-1])
        return "-".join(result)

if __name__ == '__main__':
    S = "2-5g-3-J"
    K = 2
    print(Solution().licenseKeyFormatting(S, K))