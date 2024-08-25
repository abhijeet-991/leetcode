class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length-1;
        int maxCol = matrix[0].length-1;

        List<Integer> arrayList = new ArrayList<>();

        int totalElements = matrix.length * matrix[0].length;

        int cnt = 0;
        while (cnt < totalElements) {
            //top most row
            for (int i = minCol ; i <= maxCol && cnt < totalElements; i++) {
                arrayList.add(matrix[minRow][i]);
                cnt++;
            }

            minRow = minRow + 1;

            //right most column
            for (int i = minRow; i <= maxRow && cnt < totalElements; i++) {
                arrayList.add(matrix[i][maxCol]);
                cnt++;
            }

            maxCol = maxCol - 1;

            //bottom most row
            for (int i = maxCol; i >= minCol && cnt < totalElements ; i--) {
                arrayList.add(matrix[maxRow][i]);
                cnt++;
            }

            maxRow = maxRow - 1;

            //left most row
            for (int i = maxRow; i >= minRow && cnt < totalElements; i--) {
                arrayList.add(matrix[i][minCol]);
                cnt++;
            }

            minCol = minCol + 1 ;
        }
        return arrayList;
    }
}