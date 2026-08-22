class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = 2 * n;
        int[] dist = new int[m];
        Arrays.fill(dist, m);
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int value = nums[i % n];
            if (last.containsKey(value)) {
                dist[i] = Math.min(dist[i], i - last.get(value));
            }
            last.put(value, i);
        }
        Map<Integer, Integer> next = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int value = nums[i % n];

            if (next.containsKey(value)) {
                dist[i] = Math.min(dist[i], next.get(value) - i);
            }
            next.put(value, i);
        }
        for (int i = 0; i < n; i++) {
            dist[i] = Math.min(dist[i], dist[i + n]);
        }
        List<Integer> answer = new ArrayList<>();
        for (int q : queries) {
            answer.add(dist[q] >= n ? -1 : dist[q]);
        }
        return answer;
    }
}