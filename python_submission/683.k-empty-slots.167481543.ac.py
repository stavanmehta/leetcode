class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        garden = [[i - 1, i + 1] for i in range(len(flowers))]
        garden[0][0], garden[-1][1] = None, None
        ans = -1
        for i in range(len(flowers) - 1, -1, -1):
            cur = flowers[i] - 1
            left, right = garden[cur]
            if right != None and right - cur == k + 1:
                ans = i + 1
            if left != None and cur - left == k + 1:
                ans = i + 1
            if right != None:
                garden[right][0] = left
            if left != None:
                garden[left][1] = right
        return ans
