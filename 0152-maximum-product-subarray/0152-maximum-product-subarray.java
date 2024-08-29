class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prefix = 1;
        int suffix = 1;
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length-i-1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}