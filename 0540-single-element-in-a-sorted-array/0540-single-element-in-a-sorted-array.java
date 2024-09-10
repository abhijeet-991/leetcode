class Solution {
    
    public int singleNonDuplicate(int[] nums) {
        int s = 1; // Starting index for the search (ignoring first element)
        int e = nums.length - 2; // Ending index for the search (ignoring last element)

        // Edge case: if the array has only one element, return it as the answer.
        if (nums.length == 1) {
            return nums[0];
        }

        // Check if the single element is the first element
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // Check if the single element is the last element
        if (nums[nums.length - 1] != nums[e]) {
            return nums[nums.length - 1];
        }

        // Perform binary search to find the single element
        while (s <= e) {
            int m = s + (e - s) / 2; // Calculate the mid-point of the current range

            // Check if the middle element is the single element
            if (nums[m - 1] != nums[m] && nums[m] != nums[m + 1]) {
                return nums[m]; // If `nums[m]` is not equal to its neighbors, it's the single element
            }

            // The array is grouped in pairs except for the single element.
            // If `m` is odd and `nums[m]` is paired with `nums[m-1]`, the single element lies to the right.
            // If `m` is even and `nums[m]` is paired with `nums[m+1]`, the single element lies to the right.
            if (m % 2 != 0 && nums[m - 1] == nums[m] || (m % 2 == 0 && nums[m] == nums[m + 1])) {
                s = m + 1; // Move search to the right half
            } else {
                e = m - 1; // Move search to the left half
            }

            // Example:
            // nums = [1, 1, 2, 3, 3, 4, 4, 5, 5]
            // s = 1, e = 7, m = 4
            // nums[3] == nums[4], so the single element lies to the right.
            // Now s = 5, e = 7, and repeat the process.
        }

        // When the loop ends, `s` points to the single non-duplicate element.
        return nums[s];
    }
}