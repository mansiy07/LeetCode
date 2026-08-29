class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int row = 0; row < n; row++) {
            int i = row;
            int j = 0;
            java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
            while (i < n && j < n) {
                list.add(grid[i][j]);
                i++;
                j++;
            }
            list.sort(java.util.Collections.reverseOrder());
            i = row;
            j = 0;
            for (int val : list) {
                grid[i][j] = val;
                i++;
                j++;
            }
        }
        for (int col = 1; col < n; col++) {
            int i = 0;
            int j = col;
            java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
            while (i < n && j < n) {
                list.add(grid[i][j]);
                i++;
                j++;
            }
            java.util.Collections.sort(list);
            i = 0;
            j = col;
            for (int val : list) {
                grid[i][j] = val;
                i++;
                j++;
            }
        }
        return grid;
    }
}