from collections import OrderedDict

class LRUCache(object):

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
        if not self.cache.has_key(key):
            return -1
        val = self.cache.get(key)
        del self.cache[key]
        self.cache[key] = val
        return val
            

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if self.get(key) == -1 and len(self.cache) == self.capacity:
            del self.cache[self.cache.keys()[0]]
        # if self.get(key) == -1:
        self.cache[key] = value


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
