class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int firstNumberIndex = 0; firstNumberIndex < nums.length; firstNumberIndex++) {
            if (firstNumberIndex > 0 && nums[firstNumberIndex] == nums[firstNumberIndex - 1]) {
                continue;  // Skip duplicates for the first number
            }
            int secondNumberIndex = firstNumberIndex + 1;
            int thirdNumberIndex = nums.length - 1;
            while (secondNumberIndex < thirdNumberIndex) {
                if (nums[firstNumberIndex] + nums[secondNumberIndex] + nums[thirdNumberIndex] == 0) {
                    ans.add(Arrays.asList(nums[firstNumberIndex], nums[secondNumberIndex], nums[thirdNumberIndex]));

                    //skip duplicates from the left
                    while (secondNumberIndex < thirdNumberIndex && nums[secondNumberIndex] == nums[secondNumberIndex + 1]) {
                        secondNumberIndex++;
                    }
                    //skip duplicates from the right
                    while (secondNumberIndex < thirdNumberIndex && nums[thirdNumberIndex] == nums[thirdNumberIndex - 1]) {
                        thirdNumberIndex--;
                    }

                    secondNumberIndex++;
                    thirdNumberIndex--;
                } else if (nums[firstNumberIndex] + nums[secondNumberIndex] + nums[thirdNumberIndex] > 0) {
                    thirdNumberIndex--;
                } else {
                    secondNumberIndex++;
                }
            }
        }
        return ans;
    }
}