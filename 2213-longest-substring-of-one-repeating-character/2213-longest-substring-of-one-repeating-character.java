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
        Node res = new Node(
            left.len + right.len,
            0, 0, 0,
            left.leftChar,
            right.rightChar
        );
        res.pref = left.pref;

        if (left.pref == left.len &&
            left.rightChar == right.leftChar) {
            res.pref += right.pref;
        }
        res.suff = right.suff;

        if (right.suff == right.len &&
            left.rightChar == right.leftChar) {
            res.suff += left.suff;
        }
        res.best = Math.max(left.best, right.best);
        if (left.rightChar == right.leftChar) {
            res.best = Math.max(
                res.best,
                left.suff + right.pref
            );
        }
        return res;
    }
    void build(int index, int low, int high) {
        if (low == high) {
            char c = s.charAt(low);

            tree[index] = new Node(
                1, 1, 1, 1, c, c
            );

            return;
        }
        int mid = low + (high - low) / 2;

        build(index * 2, low, mid);
        build(index * 2 + 1, mid + 1, high);

        tree[index] = merge(
            tree[index * 2],
            tree[index * 2 + 1]
        );
    }
    void update(int index, int low, int high,
                int pos, char c) {

        if (low == high) {
            tree[index] = new Node(
                1, 1, 1, 1, c, c
            );
            return;
        }
        int mid = low + (high - low) / 2;

        if (pos <= mid) {
            update(index * 2, low, mid, pos, c);
        } else {
            update(index * 2 + 1, mid + 1, high, pos, c);
        }
        tree[index] = merge(
            tree[index * 2],
            tree[index * 2 + 1]
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
            update(1, 0, n - 1, index, c);
            answer[i] = tree[1].best;
        }
        return answer;
    }
}