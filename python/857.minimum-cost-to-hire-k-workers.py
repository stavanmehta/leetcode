from fractions import Fraction
import heapq

class Solution(object):
    def mincostToHireWorkers(self, quality, wage, K):
        workers = sorted((Fraction(w, q), q, w)
                         for q, w in zip(quality, wage))

        ans = float('inf')
        pool = []
        sumq = 0
        for ratio, q, w in workers:
            heapq.heappush(pool, -q)
            sumq += q

            if len(pool) > K:
                sumq += heapq.heappop(pool)

            if len(pool) == K:
                ans = min(ans, ratio * sumq)

        return float(ans)

if __name__ == '__main__':
    quality = [4, 5]
    wage = [8, 14]
    K = 2
    print(Solution().mincostToHireWorkers(quality, wage, K))