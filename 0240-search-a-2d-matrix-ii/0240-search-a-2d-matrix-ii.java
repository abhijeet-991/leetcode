class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int j = m - 1;
        
        for (int i = 0; i < n; i++) {
            while (j >= 0 && matrix[i][j] >= target) {
                if (matrix[i][j] == target) {
                    return true;
                }
                j--;
            }
        }
        return false;
    }
}