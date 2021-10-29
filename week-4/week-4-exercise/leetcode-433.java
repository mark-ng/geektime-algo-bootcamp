/**
 * 題目： 最小基因变化 (Medium)
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> hashbank = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String b: bank) {
            hashbank.add(b);
        }
        if(!hashbank.contains(end)) return -1;
        // System.out.println(hashbank);
        char[] genes = {'A','C','G','T'};
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        map.put(start, 0);
        while(!q.isEmpty()) {
            String top = q.poll();
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 4; j++) {
                    if(genes[j] != top.charAt(i)) {
                        StringBuilder sb = new StringBuilder(top);
                        sb.setCharAt(i, genes[j]);
                        String newStr = sb.toString();
                        System.out.println(newStr);
                        if(hashbank.contains(newStr)) {
                            q.offer(newStr);
                            map.put(newStr, map.get(top) + 1);
                            if(newStr.equals(end)) {
                                return map.get(newStr);
                            }
                        }
                        
                    }
                }
            }
        }
        return -1;
    }
}