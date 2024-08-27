class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> set = new HashSet<>();
    
    for (int i = 0; i < nums.length; i++) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            int potentialThirdNum = -(nums[i] + nums[j]);
            if (hashSet.contains(potentialThirdNum)) {
                List<Integer> list = Arrays.asList(nums[i], nums[j], potentialThirdNum);
                Collections.sort(list);
                set.add(list);
            }
            hashSet.add(nums[j]);
        }
    }
    
    return new ArrayList<>(set);
}

}