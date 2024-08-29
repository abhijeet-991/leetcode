class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int mid = lo + (hi-lo)/2;
        int firstHalf = mergeSort(nums, lo, mid);
        int secondHalf = mergeSort(nums, mid+1, hi);
        int countInversions = countInversionHelper(nums, lo, mid, hi);
        merge(nums, lo, mid, hi);

        return firstHalf+secondHalf+countInversions;
    }

    private int countInversionHelper(int[] num, int lo, int mid, int hi) {
        int cnt = 0;
        int right = mid+1;
        for (int i = lo; i <= mid; i++) {
            while (right <= hi && (long)num[i] > 2 * (long)num[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

        private static void merge(int[] nums, int left, int mid, int right) {
        // Calculate the sizes of the two subarrays to be merged
        int n1 = mid - left + 1; // Size of the left subarray
        int n2 = right - mid;    // Size of the right subarray

        // Create temporary arrays to hold the elements of the two subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to the temporary left array
        // Example: For nums = [3, 9, 10, 27, 38, 43, 82], leftArray would be [3, 9, 10, 27].
        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[left + i];
        }

        // Copy data to the temporary right array
        // Example: For nums = [3, 9, 10, 27, 38, 43, 82], rightArray would be [38, 43, 82].
        for (int j = 0; j < n2; j++) {
            rightArray[j] = nums[mid + 1 + j];
        }

        // Merge the two subarrays back into the original array
        int i = 0; // Pointer for leftArray
        int j = 0; // Pointer for rightArray
        int k = left; // Pointer for the original array

        // Merge the subarrays while both have elements left
        // Example: For leftArray = [3, 9, 10, 27] and rightArray = [38, 43, 82],
        // merge them to get [3, 9, 10, 27, 38, 43, 82].
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftArray (if any)
        // If leftArray has remaining elements, they are already in sorted order.
        // Example: If leftArray = [27] and rightArray = [], copy 27 to nums.
        while (i < n1) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray (if any)
        // If rightArray has remaining elements, they are already in sorted order.
        // Example: If rightArray = [38, 43, 82] and leftArray is empty, copy them to nums.
        while (j < n2) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }

}