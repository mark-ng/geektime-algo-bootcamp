// 80 3 20 3 100 3
// 100 3, 80 3, 20 3
// [xxx, xxx, 100]

import java.util.*;

public class Main {
    
    class Node implements Comparable<Node> {
        int x,y;
        public Node(int x, int y){ this.x= x; this.y = y;}
        public String toString() {
            return x + "," + y; 
        }
        
        public int compareTo(Node otherNode) {
            if (otherNode == null) {
                return -1000000;
            }
	
    		if (this.x != otherNode.x) {
    		    return this.x - otherNode.x;
    		} else {
    		    return this.y - otherNode.y;
    		}
    		
		
	    }	
    }
    
    void run(){
        while(jin.hasNext()){
            int n = jin.nextInt();
            // List<Node> list = new ArrayList<>();
            a = new ArrayList<>();
            for (int i = 0 ; i < n ; i++){
                int p = jin.nextInt();
                int d = jin.nextInt();
                a.add(new Node(p, d));
                // a[i] = new Node(p, d);
            }
            // System.out.println(a);
            solve(a, n);
        }

    }
    
    void solve(List<Node> a, int n) {
        fa = new int[10001];
        Collections.sort(a);
        // System.out.println(a);
        for (int i = 0; i <= 10000; i++) fa[i] = i;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int profit = a.get(i).x;
            int day = a.get(i).y;
            int lastAvailableDay = find(day);
            if (lastAvailableDay > 0) {
                ans += profit;
                fa[lastAvailableDay] = lastAvailableDay - 1;
            }
        }
        System.out.println(ans);
    }
    
    int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }
    
    private Scanner jin = new Scanner(System.in);
    private List<Node> a ;
    private int[] fa;
    
}