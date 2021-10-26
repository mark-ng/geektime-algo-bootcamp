/**
 * 題目：电话号码的字母组合 (Medium)
 */
class Solution {

    private List<String> tempStrs;
    private List<String> ans;
    private String digits;
    private HashMap<String, String> map;

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new ArrayList<>();
        }
        this.digits = digits;
        map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        ans = new ArrayList<>();
        dfs(0, "");
        return ans;
    }

    private void dfs(int idx, String str) {
        if (idx == digits.length()) {
            ans.add(str);
            return;
        }
        String curChar = String.valueOf(digits.charAt(idx));
        String neigbours = map.get(curChar);
        for(int i = 0; i < neigbours.length(); i++) {
            String tempStr = str + String.valueOf(neigbours.charAt(i));
            dfs(idx + 1, tempStr);
        }
    }
}