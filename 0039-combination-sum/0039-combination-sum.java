class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(candidates, target, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> integers, int idx) {
        if (idx == candidates.length || target <= 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(integers));
            }
            return;
        }

        //include
        integers.add(candidates[idx]);
        combinationSumHelper(candidates, target - candidates[idx], ans, integers, idx);
        integers.remove(integers.size()-1);
        
        //exclude
        combinationSumHelper(candidates, target, ans, integers, idx+1);
    }
}