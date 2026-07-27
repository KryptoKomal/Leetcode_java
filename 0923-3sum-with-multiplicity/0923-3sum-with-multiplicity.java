class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long cnt = 0;
        Arrays.sort(arr);

        int mod = 1000000007;

        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {

                    // Case 1 : All elements between left & right are same
                    if (arr[left] == arr[right]) {
                        long n = right - left + 1;
                        cnt += n * (n - 1) / 2;
                        break;
                    }

                    // Case 2 : Different elements
                    int lc = 1;
                    int rc = 1;

                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        lc++;
                        left++;
                    }

                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rc++;
                        right--;
                    }

                    cnt += (long) lc * rc;

                    left++;
                    right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return (int) (cnt % mod);
    }
}