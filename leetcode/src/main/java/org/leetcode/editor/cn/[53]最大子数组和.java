package org.leetcode.editor.cn;//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4165 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int tmp = 0;
        if (nums.length == 1){
            return nums[0];
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(i == 0){
                    max = tmp = nums[i];
                }else {
                    max = Math.max(max+nums[i],nums[i]);
                    tmp = Math.max(max,tmp);
                }
            }
        }
        return tmp;
    }
}
class Main53{
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution53.maxSubArray(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
