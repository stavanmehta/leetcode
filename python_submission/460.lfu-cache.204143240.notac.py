from collections import OrderedDict

class LFUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.cache = OrderedDict()

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        val = self.cache.get(key)
        if not val:
            return -1 
        
        del self.cache[key]
        self.cache[key] = val
        return val
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if self.capacity < 1:
            return
        
        if self.get(key) == -1 and len(self.cache) == self.capacity:
            del self.cache[self.cache.keys()[0]]
        self.cache[key] = value
        


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
