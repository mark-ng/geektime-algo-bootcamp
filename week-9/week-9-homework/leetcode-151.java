/**
 * 題目： 翻转字符串里的单词 (Median)
 */

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] cArr = s.split(" ");
        cArr = Arrays.stream(cArr).filter(x -> !x.equals("")).toArray(String[]::new);
        reverseString(cArr);
        return String.join(" ", cArr);
        
    }

     public void reverseString(String[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private void swap(String[] s, int l, int r) {
        String temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}