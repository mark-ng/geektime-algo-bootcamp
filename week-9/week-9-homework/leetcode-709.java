/**
 * 題目： 转换成小写字母 (Easy)
 */

class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c: s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('a' + (c - 'A')));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}