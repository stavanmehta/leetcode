/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (55.92%)
 * Total Accepted:    239.5K
 * Total Submissions: 428.4K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        List<Integer> result = new ArrayList<Integer>();
        if (l1 > l2) {
            Arrays.sort(nums2);
            //loop through nums1
            for (int i = 0; i < nums1.length; i++) {
                int target = nums1[i];
                // and search for intersecting elements
                if (binarySearch(nums2, 0, l2-1, target) && !result.contains(target)) {
                    result.add(target);                   
                }
                    
            }
            
        } else {
            Arrays.sort(nums1);
            //loop through nums2
            // and search for intersecting elements
             for (int i = 0; i < nums2.length; i++) {
                int target = nums2[i];
                // and search for intersecting elements
                if (binarySearch(nums1, 0, l1-1, target) && !result.contains(target)) {
                    result.add(target);                   
                }
                    
            }
        }
     return result.stream().mapToInt(i->i).toArray();
    }
    
    public boolean binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}
