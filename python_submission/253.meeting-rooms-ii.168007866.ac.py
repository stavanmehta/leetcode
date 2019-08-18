# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if not intervals:
            return 0
        queue=[]
        for time in intervals:
            queue.append([time.start,1])
            queue.append([time.end,0])
        
        queue.sort()
        room=0
        count=0
        for num in queue:
            if num[1]:
                count+=1
            else:
                count-=1
            room=max(room,count)
        return room

