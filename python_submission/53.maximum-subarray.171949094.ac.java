class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndinghere = nums[0];
        
        for (int index = 1; index < nums.length; index++){
            maxEndinghere = Math.max(maxEndinghere+nums[index],nums[index]);
            maxSoFar = Math.max(maxSoFar, maxEndinghere);
        }
        return maxSoFar;
    }
}
