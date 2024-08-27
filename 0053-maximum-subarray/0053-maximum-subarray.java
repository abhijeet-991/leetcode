class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int currentBestSum = 0;

        for (int num : nums) {
            currentBestSum = Math.max(currentBestSum + num, num);
            ans = Math.max(currentBestSum, ans);
        }

        return ans;
    }
}