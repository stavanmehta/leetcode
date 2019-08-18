class Solution(object):
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        from collections import defaultdict
        
        diagonalList = []
        dd = defaultdict(list)
        for i in xrange(len(matrix)):
            for j in xrange(len(matrix[0])):
                dd[i+j+1].append(matrix[i][j])

        for key, value in dd.items():
            if key%2 != 0:
                value.reverse()
            diagonalList += value
        return diagonalList
