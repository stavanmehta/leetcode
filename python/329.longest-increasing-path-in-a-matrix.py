class Solution:
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    def longestIncreasingPath(self, matrix):
        if not matrix:
            return 0
        rcnt = len(matrix)
        ccnt = len(matrix[0])
        cache = [[0] * ccnt for _ in range(rcnt)]
        ans = 0
        for i in range(rcnt):
            for j in range(ccnt):
                ans = max(ans, self.dfs(matrix, i, j, cache))
        return ans

    def dfs(self, matrix, i, j, cache):

        if cache[i][j] != 0:
            return cache[i][j]

        res = 1
        for direction in self.directions:
            x = i + direction[0]
            y = j + direction[1]

            dircnt = 0
            if 0 <= x and x < len(matrix) and 0 <= y and y < len(matrix[0]) and matrix[x][y] > matrix[i][j]:
                dircnt = 1 + self.dfs(matrix, x, y, cache)

            res = max(res, dircnt)
        cache[i][j] = res
        return res

if __name__ == '__main__':
    nums =[[9, 9, 4],[6, 6, 8],[2, 1, 1]]

    print(Solution().longestIncreasingPath(nums))