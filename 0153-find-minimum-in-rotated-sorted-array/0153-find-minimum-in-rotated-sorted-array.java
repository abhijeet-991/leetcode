class Solution {
    public int findMin(int[] arr) {
    int s = 0;
    int min = Integer.MAX_VALUE;
    int e = arr.length - 1;

    while (s <= e) {
        int m = s + (e - s) / 2;

        if (arr[s] <= arr[m]) {
            min = Math.min(arr[s], min);
            s = m + 1;
        } else {
            min = Math.min(arr[m], min);
            e = m - 1;
        }
    }

    return min;
}
}