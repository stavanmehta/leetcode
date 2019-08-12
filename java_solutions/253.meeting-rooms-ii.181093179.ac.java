/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 *
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 * algorithms
 * Medium (43.30%)
 * Total Accepted:    169.4K
 * Total Submissions: 391.2K
 * Testcase Example:  '[[0,30],[5,10],[15,20]]'
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * 
 * 
 * Input: [[7,10],[2,4]]
 * Output: 1
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
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
        if (intervals.length == 0)
            return 0;
        int minRooms = 0;
        int endPointer = 0;
        
        int[] start = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++)
            start[i] = intervals[i].start;
        
        int[] end = new int[intervals.length];        
        for (int j = 0; j < intervals.length; j++)
            end[j] = intervals[j].end;
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        for (int index = 0; index < intervals.length; index++) {
            if (start[index] < end[endPointer])
                minRooms++;
            else
                endPointer++;
        }
        return minRooms;
    }
}
