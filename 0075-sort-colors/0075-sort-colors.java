class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length-1;
        while(i <= k) {
            if (nums[i] == 1) {
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, k);
                k--;
            } else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}