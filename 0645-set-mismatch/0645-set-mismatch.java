class Solution {
    public int[] findErrorNums(int[] nums) {
        // The length of the array is n, which should be the number of elements if no duplicates or missing values
        int n = nums.length;

        // Calculate the expected sum of numbers from 1 to n
        // Formula: n * (n + 1) / 2
        // This is because the sum of the first n natural numbers is always n * (n + 1) / 2.
        // We use this expected sum to compare against the actual sum.
        long expectedSum = (long) n * (n + 1) / 2;

        // Calculate the expected sum of squares of numbers from 1 to n
        // Formula: n * (n + 1) * (2n + 1) / 6
        // This is because the sum of the squares of the first n natural numbers is n * (n + 1) * (2n + 1) / 6.
        // We use this expected sum of squares to compare against the actual sum of squares.
        long expectedSumOfSquares = (long) n * (n + 1) * (2L * n + 1) / 6;

        // Initialize variables to compute the actual sum and sum of squares from the input array
        long actualSum = 0;
        long actualSumOfSquares = 0;

        // Iterate over the array to compute the actual sum and sum of squares
        // By iterating through the array, we accumulate the actual sum of elements and the sum of their squares.
        // These are then compared against the expected values to identify discrepancies.
        for (int num : nums) {
            actualSum += num;
            actualSumOfSquares += (long) num * num;
        }

        // x - y = actualSum - expectedSum
        // This difference represents (duplicate - missing) because the sum of the array will be higher by the duplicate value and lower by the missing value.
        // For example, if the array is [1, 2, 2, 4, 5], actualSum = 14 and expectedSum = 15
        // x - y = 14 - 15 = -1
        long XminusY = actualSum - expectedSum;

        // x^2 - y^2 = actualSumOfSquares - expectedSumOfSquares
        // This difference represents (duplicate^2 - missing^2). This is derived from the fact that the sum of squares in the array will be higher by the square of the duplicate value and lower by the square of the missing value.
        // For example, if the array is [1, 2, 2, 4, 5], actualSumOfSquares = 54 and expectedSumOfSquares = 55
        // x^2 - y^2 = 54 - 55 = -1
        long XsquareMinusYsquare = actualSumOfSquares - expectedSumOfSquares;

        // Compute the sum of the duplicate and missing number
        // x + y = (x^2 - y^2) / (x - y)
        // This formula comes from solving the equations:
        // x^2 - y^2 = (x - y) * (x + y) => x + y = (x^2 - y^2) / (x - y)
        // For example, if x - y = -1 and x^2 - y^2 = -1, then x + y = -1 / -1 = 1
        long XplusY = XsquareMinusYsquare / XminusY;

        // Compute the duplicate number (x) and the missing number (y)
        // Using the equations:
        // x - y = XminusY
        // x + y = XplusY
        // Solve these equations to find x and y:
        // x = (XminusY + XplusY) / 2
        // y = XplusY - x
        // For example, if XminusY = -1 and XplusY = 1:
        // x = (-1 + 1) / 2 = 0
        // y = 1 - 0 = 1
        long x = (XminusY + XplusY) / 2;
        long y = XplusY - x;

        // Return the result as an array where the first element is the duplicate number and the second element is the missing number
        // The result array contains the values we computed for x and y, which are the duplicate and missing numbers respectively.
        return new int[] { (int) x, (int) y };
    }
}