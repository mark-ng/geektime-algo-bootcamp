/**
 * 題目： 仅仅反转字母 (Easy)
 */

class Solution {
    public String reverseOnlyLetters(String s) {
        Deque<Character> stk = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                stk.push(c);
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(stk.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}