from collections import Counter
import re
class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        d = Counter(re.sub(r'[^\w\s]','',paragraph.lower()).split())
        maxCount = 0
        maxWord = ""
        for key in d:
            if key in banned:
                continue
            if (d[key] > maxCount):
                maxWord = key
                maxCount = d[key]
        return maxWord
        
