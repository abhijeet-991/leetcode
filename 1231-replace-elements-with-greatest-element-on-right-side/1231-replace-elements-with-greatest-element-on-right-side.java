class Solution {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int temp = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            int backup = arr[i];
            arr[i] = Math.max(temp, arr[i+1]);
            temp = Math.max(temp, backup);
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}