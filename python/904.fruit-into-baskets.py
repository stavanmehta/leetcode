from collections import Counter
class Solution(object):
    def totalFruit(self, tree):
        ans = i = 0
        count = Counter()
        for j, x in enumerate(tree):
            count[x] += 1
            print(count)
            while len(count) >= 3:
                print("inside while {0}".format(count))
                count[tree[i]] -= 1
                if count[tree[i]] == 0:
                    del count[tree[i]]
                i += 1
            ans = max(ans, j - i + 1)
        return ans

if __name__ == '__main__':
    res = Solution().totalFruit([3,3,3,1,2,1,1,2,3,3,4])
    print(res)