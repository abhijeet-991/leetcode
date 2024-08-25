class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int ans = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }
        ans = Math.max(cnt, ans);
        return ans;
    }
}