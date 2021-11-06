/**
 * 題目： 在 D 天内送达包裹的能力 (Medium)
 */
class Solution {
    int[] weights;
    int days;

    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        this.days = days;
        int totalWeight = 0;
        int maxWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            totalWeight += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int left = maxWeight;
        int right = totalWeight;
        while (left < right) {
            int mid = (left + right) / 2;
            if (validate(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            } 
        }
        return right;
    }

    private boolean validate(int capacity) {
        int accu = 0;
        int day = 0;
        for (int i = 0; i < weights.length; i++) {
            int nextChange = accu + weights[i];
            if (nextChange > capacity) {
                accu = 0;
                day++;
            }
            if (nextChange == capacity) {
                accu = 0;
                day++;
                continue;
            }
            accu += weights[i];

        }
        if (accu > 0) {
            day++;
        }
        return day <= days;
    }
}