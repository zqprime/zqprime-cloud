package org.leetcode.editor.cn;//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 654 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> n = new ArrayList<>(i);
            if(i == 1){
                n.add(1);
            }else {
                for (int j = 0; j < i; j++) {
                    if(j==0){
                        n.add(arr.get(i-2).get(j));
                    }else if(j == i-1){
                        n.add(arr.get(i-2).get(j-1));
                    }else {
                        n.add(arr.get(i-2).get(j-1)+arr.get(i-2).get(j));
                    }
                }
            }
            arr.add(n);
        }
        return arr;
    }
}
class Main118{
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        long start = System.currentTimeMillis();
        List<List<Integer>> generate = solution118.generate(30);
        System.out.println("耗时："+(System.currentTimeMillis()-start)+"毫秒");
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.print(integer+"  ");
            }
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
