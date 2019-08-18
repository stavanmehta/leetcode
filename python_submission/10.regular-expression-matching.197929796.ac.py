class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        import re
        result = re.search(p, s)
        if result:
            return result.group() == s
        return False
        
