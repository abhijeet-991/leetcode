class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = getFirstPosition(nums, target);
        int lastPosition = getLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int getLastPosition(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while (s <= e) {
            int m = s + (e-s)/2;
            if (nums[m] == target) {
                ans = m;
                s = m+1;
            } else if (nums[m] > target) {
                e = m-1;
            } else {
                s = m+1;
            }
        }
        return ans;
    }

    private int getFirstPosition(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while ( s <= e ) {
            int m = s + (e-s)/2;
            if (nums[m] == target) {
                ans = m;
                e = m-1;
            } else if (nums[m] > target) {
                e = m-1;
            } else {
                s = m+1;
            }
        }
        return ans;
    }
}