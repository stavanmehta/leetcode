class Solution(object):
    def isRectangleOverlap(self, rec1, rec2):
        """
        :type rec1: List[int]
        :type rec2: List[int]
        :rtype: bool
        """
        # def does_rectangle_overlap(rec1, rec2):
        # Pick the minimum of 2nd x-axis from both rectangle and subtract it with max of 1st x-axis from both rectangle
        x_axis = min(rec1[2], rec2[2]) - max(rec1[0], rec2[0])
        # Pick the minimum of 2nd y-axis from both rectangle and subtract it with max of 1st y-axis from both rectangle
        y_axis = min(rec1[3], rec2[3]) - max(rec1[1], rec2[1])
        # It overlaps, If x-axis and y-axis difference is greater than 0 Else, it doesn't overlap
        return x_axis > 0 and y_axis > 0

