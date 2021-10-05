
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = Arrays.copyOf(heights, n + 1);
        newHeights[n] = 0;
        Deque<Rect> stk = new ArrayDeque<Rect>();
        int maxArea = 0;
        for(int height: newHeights) {
            int accuWidth = 0;
            while(!stk.isEmpty() && stk.peek().height >= height) {
                accuWidth += stk.peek().width;
                maxArea = Math.max(maxArea, accuWidth * stk.peek().height);
                stk.pop();
            }
            stk.push(new Rect(height, accuWidth + 1));
        }
        return maxArea;
    }
}

public class Rect {
    public int height;
    public int width;

    public Rect(int height, int width) {
        this.height = height;
        this.width = width;
    }
}