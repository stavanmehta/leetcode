class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            
            if (sum == k) max = index + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max,index - map.get(sum-k));
            if (!map.containsKey(sum)) map.put(sum,index);
        }
        return max;
    }
}
