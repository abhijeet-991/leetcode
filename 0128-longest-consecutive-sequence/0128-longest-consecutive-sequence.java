class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, true);
        }
        for (int num : nums) {
            int toFind = num-1;
            if (hashMap.containsKey(toFind)) {
                hashMap.put(num, false);
            }
        }

        int cnt = 0;

        for (Map.Entry<Integer ,Boolean> entry : hashMap.entrySet()) {
            if (entry.getValue()) {
                int next = entry.getKey();
                while (hashMap.containsKey(next)) {
                    next++;
                    cnt++;
                }
                ans = Math.max(cnt, ans);
                cnt = 0;
            }
        }
        return ans;
    }
}