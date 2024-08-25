class Solution {
    public int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int posIndex = 0;
    int negIndex = 1;
    
    int[] result = new int[n];
    
    for (int num : nums) {
        if (num > 0) {
            result[posIndex] = num;
            posIndex += 2;
        } else {
            result[negIndex] = num;
            negIndex += 2;
        }
    }
    
    return result;
}

}