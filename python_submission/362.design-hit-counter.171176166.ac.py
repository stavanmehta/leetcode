class HitCounter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hits = {}
        self.hitCount = 0

    def hit(self, timestamp):
        """
        Record a hit.
        @param timestamp - The current timestamp (in seconds granularity).
        :type timestamp: int
        :rtype: void
        """
        self.hits[timestamp] = self.hits.get(timestamp, 0) + 1
        self.hitCount += 1

    def getHits(self, timestamp):
        """
        Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity).
        :type timestamp: int
        :rtype: int
        """
        diff = timestamp - 300
        for key, value in self.hits.items():
            if key <= diff:
                self.hitCount -= value
                del self.hits[key]
        return self.hitCount
           


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)
