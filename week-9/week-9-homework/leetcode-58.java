/**
 * 題目： 最后一个单词的长度 (Easy)
 */


class Solution {
    public int lengthOfLastWord(String s) {
        char[] cArr = s.toCharArray();
        int i = cArr.length - 1;
        while (i >= 0 && cArr[i] == ' ') {
            i--;
        }
        int ans = 0;
        while (i >= 0 && (cArr[i] >= 'A' && cArr[i] <= 'Z' || cArr[i] >= 'a' && cArr[i] <= 'z') && cArr[i] != ' ')  {
            ans ++;
            i--;
        }
        return ans;
    }
}