class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
                cnt = 1;
            } else if (candidate == num) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return candidate;
    }
}