/**
 * 題目： 实现 Trie (前缀树) (Medium)
 */


class Trie {

    class MyNode {
        int count;
        MyNode[] children;

        MyNode() {
            count = 0;
            children = new MyNode[26];
        }
    }

    MyNode root;

    public Trie() {
        root = new MyNode();
    }
    
    public void insert(String word) {
        find(word, true, false);
    }
    
    public boolean search(String word) {
        return find(word, false, false);
    }
    
    public boolean startsWith(String prefix) {
        return find(prefix, false, true);
    }

    private boolean find(String word, boolean isInsert, boolean isPrefix) {
        MyNode curr = root;
        for (char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                if (isInsert) {
                    curr.children[c - 'a'] = new MyNode();
                } else {
                    return false;
                }
            }
            curr = curr.children[c - 'a'];
        }
        if (isInsert) curr.count++;
        if (isPrefix) return true;
        return curr.count > 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */