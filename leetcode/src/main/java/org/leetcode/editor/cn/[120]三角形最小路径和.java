package org.leetcode.editor.cn;//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = {{2},{3,4},{6,5,7},{4,1,8,3}}
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = {{-10}}
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle{0}.length == 1
// triangle{i}.length == triangle{i - 1}.length + 1
// -10⁴ <= triangle{i}{j} <= 10⁴
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 👍 937 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int result = 0;
        root:for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> integers = triangle.get(i+1);
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                int min = Math.min(integers.get(j), integers.get(j + 1));
                if(list.size() == 1){
                    result = list.get(j)+min;
                    break root;
                }
                list.set(j,list.get(j)+min);
            }
        }
        return result;
    }
}
class Main120{
    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        int[][] triangle = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> nums = new ArrayList<>();
        for (int[] ints : triangle) {
            ArrayList<Integer> inter = new ArrayList<>();
            for (int anInt : ints) {
                inter.add(anInt);
            }
            nums.add(inter);
        }
        System.out.println(solution120.minimumTotal(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
