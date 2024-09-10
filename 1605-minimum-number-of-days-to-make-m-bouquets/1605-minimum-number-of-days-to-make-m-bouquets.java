class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int s = Arrays.stream(bloomDay).min().getAsInt();
        int e = Arrays.stream(bloomDay).max().getAsInt();

        if (m * k > bloomDay.length) return -1;

        int ans = Integer.MAX_VALUE;

        while (s <= e) {
            int mid = s + (e-s)/2;
            int cntOfBoutique = processStuff(bloomDay, mid, k);
            if(cntOfBoutique >= m) {
                ans = Math.min(mid, ans);
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int processStuff(int[] nums, int mid, int k) {
        int cnt = 0;
        int ans = 0;
        for (int num : nums) {
            if (num <= mid) {
                cnt++;
            } else {
                ans += cnt / k;
                cnt = 0;
            }
        }
        ans += cnt/k;
        return ans;
    }
}