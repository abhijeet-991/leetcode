class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int s = 1;
        int e = Arrays.stream(nums).max().getAsInt();

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (calcSum(nums, h, m)) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    private boolean calcSum(int[] nums, int h, int m) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + m - 1) / m;
            if (sum > h) {
                return false;
            }
        }
        return sum <= h;
    }
}