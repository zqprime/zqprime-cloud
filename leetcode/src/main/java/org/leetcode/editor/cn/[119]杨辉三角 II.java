package org.leetcode.editor.cn;//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 👍 347 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex+1);
        for (int i = 1; i <= rowIndex+1; i++) {
            if(i == 1){
                result.add(1);
            }else if(i == 2){
                result.add(1);
            }else {
                int left = 1,right;
                for (int j = 1; j < i; j++) {
                    if(j == i-1){
                        result.add(1);
                    }else {
                        right = result.get(j);
                        int sum = left+right;
                        result.set(j,sum);
                        left = right;
                    }
                }
            }
        }
        return result;
    }
}
class Main119{
    public static void main(String[] args) {
        Solution119 solution119 = new Solution119();
        System.out.println(solution119.getRow(30));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
