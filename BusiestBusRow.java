public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        int maxRow = 0;
        int maxTotal = 0;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }

            if (i == 0 || total > maxTotal) {
                maxTotal = total;
                maxRow = i;
            }
        }

        return new int[]{maxRow, maxTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);

        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
