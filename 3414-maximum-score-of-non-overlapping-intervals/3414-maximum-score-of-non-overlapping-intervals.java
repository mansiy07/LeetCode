import java.util.*;

class Solution {

    class State {
        long score;
        List<Integer> ids;

        State() {
            score = 0;
            ids = new ArrayList<>();
        }

        State(long score, List<Integer> ids) {
            this.score = score;
            this.ids = new ArrayList<>(ids);
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [start, end, weight, original index]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by end time
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = arr[i][1];
        }

        // Find previous non-overlapping interval
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {

            int l = 0;
            int r = i;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (ends[mid] < arr[i][0]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            prev[i] = l;
        }

        // dp[i][k] = best answer using first i intervals
        // and selecting at most k intervals
        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State();
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                // Skip current interval
                State skip = dp[i - 1][k];

                // Take current interval
                State take = new State(
                    dp[prev[i - 1]][k - 1].score + arr[i - 1][2],
                    dp[prev[i - 1]][k - 1].ids
                );

                take.ids.add(arr[i - 1][3]);

                Collections.sort(take.ids);

                dp[i][k] = better(skip, take);
            }
        }

        // Convert List<Integer> -> int[]
        List<Integer> ans = dp[n][4].ids;

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private State better(State a, State b) {

        if (a.score > b.score) {
            return new State(a.score, a.ids);
        }

        if (b.score > a.score) {
            return new State(b.score, b.ids);
        }

        // Same score -> lexicographically smaller
        List<Integer> x = new ArrayList<>(a.ids);
        List<Integer> y = new ArrayList<>(b.ids);

        Collections.sort(x);
        Collections.sort(y);

        if (lexicographicallySmaller(x, y)) {
            return new State(a.score, x);
        }

        return new State(b.score, y);
    }

    private boolean lexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}