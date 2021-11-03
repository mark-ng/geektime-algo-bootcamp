/**
 * 題目： 制作 m 束花所需的最少天数 (Medium)
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
       // find the smallest day which is valid
       int latestBloom = 0;
       for (int bloom: bloomDay) {
           latestBloom = Math.max(latestBloom, bloom);
       }
       int left = 0;
       int right = latestBloom + 1;
       while (left < right) {
           int mid = (left + right) / 2;
           if (validate(bloomDay, m, k, mid)) {
               right = mid;
           } else {
               left = mid + 1;
           }
       }
       if (right == latestBloom + 1) {
           return -1;
       }
       return right;
   }

   // validate
   // the question ask about the number of days
   // so, I make up some days, and validate each of them
   private boolean validate(int[] bloomDay, int m, int k, int day) {
       // Can I make m bouquets using k adjacent flowers in day
       int conse = 0;
       int bouquet = 0;
       for (int bloom: bloomDay) {
           if (bloom <= day) {
               conse++;
               if (conse == k) {
                   bouquet++;
                   conse = 0;
               }
           } else {
               conse = 0;
           }
       }
       return bouquet >= m;
   }
}