import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class IslandArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 读取输入矩阵直到文件结束或输入完毕
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            sb.append(in.nextLine()).append("\n");
        }

        // 将输入数据分割成行
        String[] lines = sb.toString().trim().split("\n");
        int m = lines.length;
        int n = lines[0].split(",").length;

        // 创建矩阵
        int[][] grid = new int[m][n];

        // 填充矩阵
        for (int i = 0; i < m; i++) {
            String[] values = lines[i].split(",");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(values[j].trim());
            }
        }

        int maxArea = maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }



    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        int area = 1;
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i, j - 1);
        area += dfs(grid, i, j + 1);
        return area;
    }
}


