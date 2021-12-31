package org.leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2086 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int left = 1,right = 2;
        int times = n -2;
        int tmp;
        while (times > 0){
            tmp = right;
            right += left;
            left = tmp;
            times --;
        }
        return right;
    }
}
class Main70{
    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        for (int i = 1; i <= 41; i++) {
            System.out.println(solution70.climbStairs(i));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
