/**
 * 題目： 实现 strStr() (Easy)
 */

class Solution {
    public int strStr(String s, String t) {
        if (t.length() == 0) return 0;
        int n = s.length();
        int m = t.length();
        s = " " + s;
        t = " " + t;

        int p = (int) 1e9 + 7; // 10^9+7 是一个质数
        int b = 131;

        // Find the hash of t
        long tHash = 0;
        for (int i = 1; i <= m; i++) {
            tHash = (tHash * b + (t.charAt(i) - 'a' + 1)) % p;
        }

        // Find the prefix hash for s
        long[] sHash = new long[n + 1];
        sHash[0] = 0;
        for (int i = 1; i <= n; i++) {
            sHash[i] = (sHash[i - 1] * b + (s.charAt(i) - 'a' + 1)) % p;
        }

        // 131的次幂
        long[] p131 = new long[n + 1];
        p131[0] = 1;
        for (int i = 1; i <= n; i++) {
            p131[i] = p131[i - 1] * 131 % p;
        }

        for (int l = 1; l <= n - m + 1; l++) {
            int r = l + m - 1;
            if (((sHash[r] - sHash[l - 1] * p131[r - l + 1]) % p + p) % p == tHash) {
                return l - 1;
            }
        }

        return -1;
    }
}