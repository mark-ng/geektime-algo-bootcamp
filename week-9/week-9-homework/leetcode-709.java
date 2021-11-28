/**
 * 題目： 转换成小写字母 (Easy)
 */

class Solution {
    public String toLowerCase(String s) {
        String ans = "";
        for (char c: s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                ans += (char) ('a' + (c - 'A'));
            } else {
                ans += c;
            }
        }
        return ans;
    }
}