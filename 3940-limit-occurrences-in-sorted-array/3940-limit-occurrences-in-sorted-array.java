class Solution {
    public int[] limitOccurrences(int[] nums, int k) {

        if (nums.length <= k) {
            return nums;
        }

        int write = k;

        for (int read = k; read < nums.length; read++) {
            if (nums[read] != nums[write - k]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return java.util.Arrays.copyOf(nums, write);
    }
}