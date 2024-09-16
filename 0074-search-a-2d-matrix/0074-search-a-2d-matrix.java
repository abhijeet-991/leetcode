class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && matrix[i][m-1] >= target) {
                int low = 0;
                int hi = m-1;
                while (low <= hi) {
                    int mid = low + (hi - low)/2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        low = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}