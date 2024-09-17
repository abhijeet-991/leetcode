class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        powerSetHelper(ans, set, 0, nums.length, nums);
        return ans;
    }

    private void powerSetHelper(List<List<Integer>> ans, List<Integer> set, int i, int length, int[] nums) {
        if (i >= length) {
            ans.add(new ArrayList<>(set));
            return;
        }

        //exclude
        powerSetHelper(ans, set, i+1, length, nums);

        //include
        set.add(nums[i]);
        powerSetHelper(ans, set, i+1, length, nums);

        set.remove(set.size()-1);
    }
}