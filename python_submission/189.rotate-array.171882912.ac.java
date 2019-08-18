class Solution {
    public void rotate(int[] nums, int k) {
        int head = 0;
        int tail = nums.length - 1;
        k %= nums.length;
        
        while (head < tail) {
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
        
        for (int j = 0; j < k/2; j++) {
            int t = nums[j];
            nums[j] = nums[k - j - 1];
            nums[k - j - 1] = t;
        }
        
        int h = k;
        int ta = nums.length - 1;
        for (int l = k; l < k + (nums.length - k)/2; l++) {
            int te = nums[h];
            nums[h] = nums[ta];
            nums[ta] = te;
            h++;
            ta--;
        }
        
        return;
    }
}
