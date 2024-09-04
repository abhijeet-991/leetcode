class Solution {
    public int search(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        int ansIndex = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == k) {
                ansIndex = mid;
                break;
            }
            if (nums[start] <= nums[mid]) {
                if (k >= nums[start] && k <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (k >= nums[mid] && k <= nums[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return ansIndex;
    }
}