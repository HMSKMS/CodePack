/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * @param x int整型 目标点的X坐标
 * @param y int整型 目标点的Y坐标
 * @param z int整型 目标点的Z坐标
 * @return long长整型
 */

import java.util.*;
public class ant_xyz_climbing {
    public long countPaths(int x, int y, int z) {
        long[][][] memo = new long[x + 1][y + 1][z + 1];
        //base case
        //从起点到起点只有一种路径，那就是站着不动，这就是唯一的base case
        memo[0][0][0] = 1;
        return dp(memo, x, y, z);
    }

    //采用记忆化搜索的办法
    private long dp(long[][][] memo, int x, int y, int z) {
        //dp含义，从0,0,0到x,y,z的路径数量
        //状态转移
        //依据题意，每次都只能沿着三条坐标轴之一移动一个方向，所以到达x,y,z这个点的，只可能有这三种情况
        //从x-1,y,z过来，从x,y-1,z过来，从x,y,z-1过来
        //因此状态转移方程为
        //dp[x][y][z] = dp[x-1][y][z] + dp[x][y-1][z] + dp[x][y][z-1]
        if (x == -1 || y == -1 || z == -1) {
            return 0;
        }
        if (memo[x][y][z] != 0) {
            return memo[x][y][z];
        }
        //只能从三个方向而来
        long res = dp(memo, x - 1, y, z) + dp(memo, x, y - 1, z) + dp(memo, x, y, z - 1);
        memo[x][y][z] = res;
        return memo[x][y][z];
    }
}