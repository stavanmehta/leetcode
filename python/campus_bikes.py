from heapq import *
class Solution(object):
    def assignBikes(self, workers, bikes):
        w=len(workers)
        b=len(bikes)
        seen_bike=set()
        worker_heap_lis=[[] for _ in range(w)]
        for i in range(w):
            for j in range(b):
                worker_heap_lis[i].append((abs(workers[i][0]-bikes[j][0])+abs(workers[i][1]-bikes[j][1]),i,j))
        for lis in worker_heap_lis:
            heapify(lis)
        res=[-1]*w
        count=0
        heap=[heappop(heap) for heap in worker_heap_lis]
        heapify(heap)
        while count<w:
            _,i,j=heappop(heap)
            if j not in seen_bike:
                seen_bike.add(j)
                res[i]=j
                count+=1
            else:
                heappush(heap,heappop(worker_heap_lis[i]))
        return res

if __name__ == '__main__':
    workers = [[0,0],[1,1],[2,0]]
    bikes = [[1,0],[2,2],[2,1]]

    result = Solution().assignBikes(workers, bikes)
    print(result)