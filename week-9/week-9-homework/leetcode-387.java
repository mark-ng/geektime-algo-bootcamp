/**
 * 題目： 字符串中的第一个唯一字符 (Easy)
 */


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < cArr.length; i++) {
            if (map.get(cArr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}