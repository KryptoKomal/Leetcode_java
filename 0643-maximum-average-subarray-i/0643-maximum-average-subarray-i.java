class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        int sum = 0;

      
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int res = sum;

        int low = 0;
        int high = k - 1;

        while (high < n - 1) {

            sum -= nums[low];
            low++;

            high++;
            sum += nums[high];

            res = Math.max(res, sum);
        }

        return (double) res / k;
    }
}