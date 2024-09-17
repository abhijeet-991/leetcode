class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        parenthesisGenerator(n, n, "", ans);
        return ans;
    }

    private void parenthesisGenerator(int open, int closed, String output, List<String> ans) {
        if (open == 0 && closed == 0) {
            ans.add(output);
            return;
        }
        
        if (open != 0) {
            String newOutput = output;
            newOutput += "(";
            parenthesisGenerator(open - 1, closed, newOutput, ans);
        }
        
        if (closed > open) {
            String newOutput = output;
            newOutput += ")";
            parenthesisGenerator(open, closed-1, newOutput, ans);
        }
    }
}