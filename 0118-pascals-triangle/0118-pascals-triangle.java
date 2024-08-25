class Solution {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    
    for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
        List<Integer> currentRow = new ArrayList<>();
        
        currentRow.add(1);
        
        if (rowIndex > 0) {
            List<Integer> previousRow = triangle.get(rowIndex - 1);
            for (int colIndex = 1; colIndex < rowIndex; colIndex++) {
                int leftParent = previousRow.get(colIndex - 1);
                int rightParent = previousRow.get(colIndex);
                int currentValue = leftParent + rightParent;
                currentRow.add(currentValue);
            }
            
            currentRow.add(1);
        }
        
        triangle.add(currentRow);
    }
    
    return triangle;
}

}