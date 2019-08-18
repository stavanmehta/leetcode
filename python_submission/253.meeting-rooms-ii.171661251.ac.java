/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int index= 0; index < intervals.length; index++){
            starts[index] = intervals[index].start;
            ends[index] = intervals[index].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int endIter = 0;
        int rooms = 0;
        for (int i= 0; i < starts.length; i++){
            if(starts[i] < ends[endIter])
                rooms+=1;
            else
                endIter++;
        }
        return rooms;
    }
}
