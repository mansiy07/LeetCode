class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int row = 0; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }
        for (int col = 1; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }
        return mat;
    }
    private void sortDiagonal(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> list = new ArrayList<>();
        int i = row;
        int j = col;
        while (i < m && j < n) {
            list.add(mat[i][j]);
            i++;
            j++;
        }
        Collections.sort(list);
        i = row;
        j = col;

        int index = 0;
        while (i < m && j < n) {
            mat[i][j] = list.get(index++);
            i++;
            j++;
        }
    }
}