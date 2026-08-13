class Solution {
    class Node {
        int len;
        int pref;
        int suff;
        int best;
        char leftChar;
        char rightChar;

        Node(int len, int pref, int suff, int best,
             char leftChar, char rightChar) {
            this.len = len;
            this.pref = pref;
            this.suff = suff;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }
    Node[] tree;
    String s;

    Node merge(Node left, Node right) {
        Node result = new Node(
            left.len + right.len,
            0,
            0,
            0,
            left.leftChar,
            right.rightChar
        );
        result.pref = left.pref;

        if (left.pref == left.len &&
            left.rightChar == right.leftChar) {

            result.pref += right.pref;
        }
        result.suff = right.suff;

        if (right.suff == right.len &&
            left.rightChar == right.leftChar) {
            result.suff += left.suff;
        }
        result.best = Math.max(left.best, right.best);
        if (left.rightChar == right.leftChar) {
            result.best = Math.max(
                result.best,
                left.suff + right.pref
            );
        }
        return result;
    }
    void build(int node, int start, int end) {
        if (start == end) {
            char c = s.charAt(start);
            tree[node] = new Node(
                1, 1, 1, 1, c, c
            );
            return;
        }
        int mid = start + (end - start) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }
    void update(int node, int start, int end,
                int index, char c) {

        if (start == end) {
            tree[node] = new Node(
                1, 1, 1, 1, c, c
            );
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            update(
                node * 2,
                start,
                mid,
                index,
                c
            );
        } else {
            update(
                node * 2 + 1,
                mid + 1,
                end,
                index,
                c
            );
        }
        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }
    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        this.s = s;
        int n = s.length();
        tree = new Node[4 * n];
        build(1, 0, n - 1);
        int[] answer = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);
            update(
                1,
                0,
                n - 1,
                index,
                c
            );
            answer[i] = tree[1].best;
        }
        return answer;
    }
}