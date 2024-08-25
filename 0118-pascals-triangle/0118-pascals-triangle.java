class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> temp = ans.get(i-1);
                    for (int k = 0; k < temp.size()-1; k++) {
                        int firstElement = temp.get(k);
                        int secondElement = temp.get(k+1);
                        list.add(firstElement + secondElement);
                    }
                    list.add(1);
                    break;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}