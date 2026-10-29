class Solution {
    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        int[][] up = new int[LOG][n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] baseMask = new int[n];
        int[] parent = new int[n];
        int[] iter = new int[n];
        int[] stack = new int[n];
        char[] chars = s.toCharArray();
        int timer = 0;
        int top = 0;
        parent[0] = 0;
        baseMask[0] = 1 << (chars[0] - 'a');
        tin[0] = ++timer;
        stack[top++] = 0;
        while (top > 0) {
            int u = stack[top - 1];
            if (iter[u] < graph[u].size()) {
                int v = graph[u].get(iter[u]++);
                if (v == parent[u]) continue;
                parent[v] = u;
                depth[v] = depth[u] + 1;
                baseMask[v] = baseMask[u] ^ (1 << (chars[v] - 'a'));
                up[0][v] = u;
                for (int j = 1; j < LOG; j++) {
                    up[j][v] = up[j - 1][up[j - 1][v]];
                }
                tin[v] = ++timer;
                stack[top++] = v;
            } else {
                tout[u] = timer;
                top--;
            }
        }
        Fenwick bit = new Fenwick(n);
        List<Boolean> answer = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);
                if (chars[u] != c) {
                    int delta =
                        (1 << (chars[u] - 'a')) ^
                        (1 << (c - 'a'));
                    bit.rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int l = getLCA(u, v, depth, up);
                int maskU = baseMask[u] ^ bit.pointQuery(tin[u]);
                int maskV = baseMask[v] ^ bit.pointQuery(tin[v]);
                int mask = maskU ^ maskV ^
                           (1 << (chars[l] - 'a'));
                answer.add((mask & (mask - 1)) == 0);
            }
        }
        return answer;
    }
    private int getLCA(
            int u, int v, int[] depth, int[][] up) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int j = 0; j < up.length; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }
        if (u == v) return u;
        for (int j = up.length - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }
        return up[0][u];
    }
    static class Fenwick {
        int[] tree;
        int n;
        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 2];
        }
        void update(int i, int value) {
            while (i <= n) {
                tree[i] ^= value;
                i += i & -i;
            }
        }
        int pointQuery(int i) {
            int result = 0;
            while (i > 0) {
                result ^= tree[i];
                i -= i & -i;
            }
            return result;
        }
        void rangeXor(int l, int r, int value) {
            update(l, value);
            if (r + 1 <= n) {
                update(r + 1, value);
            }
        }
    }
}