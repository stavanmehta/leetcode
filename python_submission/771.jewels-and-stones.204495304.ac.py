class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        from collections import Counter
        scnt = Counter(S)
        total =0
        for jwl in J:
            if scnt.has_key(jwl):
                total += scnt.get(jwl)
                
        return total
