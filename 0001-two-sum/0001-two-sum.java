class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // will be num and index
        int[] ans = new int[]{-1,-1};
        for(int i = 0; i < nums.length; i++) {
            if (hashMap.get(target - nums[i]) != null) {
                ans[0] = hashMap.get(target - nums[i]);
                ans[1] = i;
                break;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return ans;
    }
}