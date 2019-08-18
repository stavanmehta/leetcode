/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (38.73%)
 * Total Accepted:    240.5K
 * Total Submissions: 620.8K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        //measure the in degree of each course
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                inDegree[ready]++;
            matrix[pre][ready] = 1;
        }
        
        //finish the course with the in degree 0 or no dependency
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int j = 0; j < inDegree.length; j++)  {
            if (inDegree[j] == 0)
                queue.offer(j);
        }
        
        //finish the pre req and check if the course can be taken
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for(int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--inDegree[i]==0)
                        queue.offer(i);
                }
            }
        }
        // compare the courses taken vs total number of courses
        return count == numCourses;
    }
}
