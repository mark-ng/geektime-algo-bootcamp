/**
 * 題目： 搜索二维矩阵 (Medium)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int totalLength = m * n;
        int[] sortedArr = new int[totalLength];
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                sortedArr[count] = matrix[r][c];
                count++;
            }
        }
        int left = 0;
        int right = totalLength;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedArr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (right == totalLength) return false;
        return sortedArr[right] == target;
    }
    
}