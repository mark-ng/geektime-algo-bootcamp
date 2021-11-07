/**
 * 題目： 数组中的第 K 个最大元素 (Medium)
 */
class Solution {
    // O(n) by quick sort thinking
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSort(int[] arr, int l, int r, int index) {
        if (l >= r) return arr[l];
        int pivot = partition(arr, l, r);
        if (index <= pivot) return quickSort(arr, l, pivot, index);
        else return quickSort(arr, pivot + 1, r, index);
    }

    static int partition(int[] a, int l, int r) {
        int pivot = l + (int) (Math.random() * (r - l + 1));
        int pivotVal = a[pivot];

        while (l <= r) {
            while (a[l] < pivotVal) l++;
            while (a[r] > pivotVal) r--;
            if (l == r) break;
            if (l < r) {
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
        }

        return r;
    }
}