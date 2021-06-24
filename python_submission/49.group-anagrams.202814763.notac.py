from collections import Counter

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        output = list()
        tmpanagram = list()
        for index, str in enumerate(strs):
            anagrams = list()
            if str in tmpanagram:
                continue
            anagrams.append(str)
            for word in strs[index + 1:]:
                if self.is_anagram(str, word):
                    anagrams.append(word)
                    tmpanagram.append(word)
            if anagrams:
                output.append(anagrams)
        return output
    
    def is_anagram(self, word1, word2):
        w1counter = Counter(word1)
        w2counter = Counter(word2)
        return sorted(w1counter.keys()) == sorted(w2counter.keys())
        
