/**
 * 題目：最大矩形 (Hard)
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        // Turn the grid from char matrix to int matrix
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < intMatrix.length; i++) {
            for(int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }
        // Build a new grid
        int[][] newGrid = buildNewGrid(intMatrix);
        int maxArea = 0;
        for(int row = 0; row < newGrid.length; row++) {
            maxArea = Math.max(maxArea, largestRectangleArea(newGrid[row]));
        }
        return maxArea;
    }

    public int[][] buildNewGrid(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++) {
            newMatrix[0][i] = matrix[0][i];
        }
        for(int row = 1; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    newMatrix[row][col] = 0;
                } else {
                    newMatrix[row][col] = newMatrix[row-1][col] + 1;
                }
            }
        }
        return newMatrix;
    }

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

    public class Rect {
        public int height;
        public int width;

        public Rect(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }
}