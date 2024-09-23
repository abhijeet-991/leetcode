class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s, ans, 0, new ArrayList<>());
        return ans;
    }

    private void partitionHelper(String s, List<List<String>> ans, int idx, ArrayList<String> list) {

        if(idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                list.add(s.substring(idx, i+1));
                partitionHelper(s, ans, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String prefix, int start, int end) {

        if (start > end) {
            return true;
        }

        if (prefix.charAt(start) != prefix.charAt(end)) {
            return false;
        }

        return isPalindrome(prefix, start+1, end-1);
    }
}