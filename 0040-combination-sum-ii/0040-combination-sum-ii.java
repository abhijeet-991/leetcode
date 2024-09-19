class Solution {
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, ans, 0, new ArrayList<Integer>());
        return ans;
    }

    private void combinationSum2Helper(int[] candidates, int target, List<List<Integer>> ans, int idx, ArrayList<Integer> arrayList) {
        if (target == 0) {
            ans.add(new ArrayList<>(arrayList));
            return;
        }

        if (idx >= candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                return;
            }
            arrayList.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], ans, i + 1, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}