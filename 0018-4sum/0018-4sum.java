class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ansList = new ArrayList<>();
    if (nums.length < 4) {
        return new ArrayList<>();
    }
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 3; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue; // Skip duplicate elements for i
        }

        for (int j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue; // Skip duplicate elements for j
            }

            int k = j + 1;
            int l = nums.length - 1;
            while (k < l) {
                long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                if (sum == target) {
                    ansList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                    while (k < l && nums[k] == nums[k + 1]) k++;
                    while (k < l && nums[l] == nums[l - 1]) l--;

                    k++;
                    l--;
                } else if (sum > target) {
                    l--;
                } else {
                    k++;
                }
            }
        }
    }
    return ansList;
}

}