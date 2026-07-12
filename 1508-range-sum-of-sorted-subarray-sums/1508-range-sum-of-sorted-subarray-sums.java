class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> sumOfAllSub = getSumOfAllSubarrays(nums);

        long ans = 0;
        long MOD = 1_000_000_007L;

        for (int i = left - 1; i < right; i++) {
            ans = (ans + sumOfAllSub.get(i)) % MOD;
        }

        return (int) ans;
    }

    public ArrayList<Integer> getSumOfAllSubarrays(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> lst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                lst.add(sum);
            }
        }

        Collections.sort(lst);
        return lst;
    }
}