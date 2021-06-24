class MovingAverage(object):

    def __init__(self, size):
        """
        Initialize your data structure here.
        :type size: int
        """
        self.size = size
        self.counter = 0
        self.values = []
        

    def next(self, val):
        """
        :type val: int
        :rtype: float
        """
        self.counter = self.counter+1 if self.counter < self.size else self.size
        self.values.append(val)
        sum = 0
        for i in range(0, self.counter):
            sum += self.values[len(self.values)-1-i]
        return float(sum/float(self.counter))
        


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)
