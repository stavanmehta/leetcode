class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.numbers = []
        

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        self.numbers.append(num)
        self.numbers = sorted(self.numbers)
        

    def findMedian(self):
        """
        :rtype: float
        """
        # self.numbers = sorted(self.numbers)
        length = len(self.numbers)
        index = length/2
        if length%2 == 0:
            return (self.numbers[index-1] + self.numbers[index])/2.0
        elif length%2 == 1:
            return float(self.numbers[index])
            
        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
