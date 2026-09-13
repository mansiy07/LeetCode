class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[][] p1 = new int[n * n][2];
        int[][] p2 = new int[n * n][2];
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    p1[c1][0] = i;
                    p1[c1][1] = j;
                    c1++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img2[i][j] == 1) {
                    p2[c2][0] = i;
                    p2[c2][1] = j;
                    c2++;
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < c1; i++) {
            for (int j = 0; j < c2; j++) {
                int dx = p1[i][0] - p2[j][0];
                int dy = p1[i][1] - p2[j][1];
                String key = dx + "," + dy;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}