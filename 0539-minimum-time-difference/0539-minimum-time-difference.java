class Solution {
    public int findMinDifference(List<String> timePoints) {
    int n = timePoints.size();
    boolean[] buckets = new boolean[24 * 60];
    for (int i = 0; i < n; i++) {
        int t = parse(timePoints.get(i));
        if (buckets[t]) return 0;
        buckets[t] = true;
    }

    int min = Integer.MAX_VALUE;
    int pre = 0, first = -1;
    for (int i = 0; i < buckets.length; i++) {
        if (buckets[i]) {
            if (first == -1) first = i;
            else min = Math.min(min, i - pre);
            pre = i;
        }
    }
    min = Math.min(min, first - pre + 24 * 60);
    return min;
}

int parse(String s) {
    String[] split = s.split(":");
    int h = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    return h * 60 + m;
}
}