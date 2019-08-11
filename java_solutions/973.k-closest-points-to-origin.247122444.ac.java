/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * algorithms
 * Medium (61.56%)
 * Total Accepted:    88K
 * Total Submissions: 143K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 *
 * We have a list of points on the plane.  Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean
 * distance.)
 * 
 * You may return the answer in any order.  The answer is guaranteed to be
 * unique (except for the order that it is in.)
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * 
 * 
 * 
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        /* initial solution
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] *p2[1]);
        return Arrays.copyOfRange(points, 0, K);
        */
        // another solution
        /*
            Maintain an arrray of distances and sort them - take K-1 and compare the distance of the points
        */
        
        int n = points.length;
        int[] distances = new int[n];
        for (int i = 0; i < n; i++)
            distances[i] = findDistance(points[i]);
        Arrays.sort(distances);
        int distK = distances[K-1];
        int[][] result = new int[K][2];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            if (findDistance(points[i]) <= distK)
                result[index++] = points[i];
        }
        return result;
    }
    
    private int findDistance(int[] points) {
        return points[0]* points[0] + points[1] * points[1];
    }
}
