class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2= -1, cnt1 = 0, cnt2 = 0;
        for (int num: nums) {
            if (cnt1 == 0 && candidate2 != num) {
                candidate1 = num;
                cnt1 = 1;
            } else  if (cnt2 == 0 && candidate1 != num) {
                candidate2 = num;
                cnt2 = 1;
            } else if (num == candidate1) {
                cnt1++;
            } else if (num == candidate2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (candidate1 == num) cnt1++;
            if (candidate2 == num) cnt2++;
        }
        if (cnt1 > nums.length/3 && cnt2 > nums.length/3) {
            return List.of(candidate1, candidate2);
        } else if (cnt1 > nums.length/3) {
            return List.of(candidate1);
        } else if (cnt2 > nums.length/3) {
            return List.of(candidate2);
        }
        return Collections.emptyList();
    }
}