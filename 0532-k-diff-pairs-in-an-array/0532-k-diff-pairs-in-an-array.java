class Solution {
    boolean binarySearch(int nums[], int low, int high, int k, int firstSelected) {
        if (low >= nums.length) return false;
        int mid;
        int temp;
        while (low <= high) {
            mid = (low + (high - low) / 2);
            temp = Math.abs(firstSelected - nums[mid]);
            if (temp == k) {
                return true;
            }
            else if (temp < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int prev = Integer.MIN_VALUE;
        for(int r = 0; r<nums.length; ++r) {
            if(prev == nums[r])continue;
            if (binarySearch(nums, r + 1, nums.length - 1, k, nums[r])) ++result;
            prev = nums[r];
        }   
        return result;
    }
}