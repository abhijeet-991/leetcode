class Solution {
    public int splitArray(int[] array, int numPartitions) {
        int result = -1;
        if (numPartitions > array.length) {
            return result;
        }

        int maxElement = Arrays.stream(array).max().getAsInt();
        int totalSum = Arrays.stream(array).sum();

        while (maxElement <= totalSum) {
            int mid = maxElement + (totalSum - maxElement) / 2;
            if (canDivideArray(array, mid) <= numPartitions) {
                result = mid;
                totalSum = mid - 1;
            } else {
                maxElement = mid + 1;
            }
        }

        return result;
    }

    private int canDivideArray(int[] array, int maxSumPerPartition) {
        int partitionsRequired = 1;
        int currentPartitionSum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] + currentPartitionSum <= maxSumPerPartition) {
                currentPartitionSum += array[i];
            } else {
                partitionsRequired++;
                currentPartitionSum = array[i];
            }
        }

        return partitionsRequired;
    }
}