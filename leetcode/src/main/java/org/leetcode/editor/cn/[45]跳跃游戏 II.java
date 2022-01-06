package org.leetcode.editor.cn;//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution45 {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int times = 0;
        for (int i = nums.length-1; i > 0;) {
            for (int j = 0; j <= i; j++) {
                if(nums[j] >= i-j){
                    i = j;
                    times++;
                    break;
                }
            }
        }
        return times;
    }
}
class Main45{
    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
//        int[] ints = new int[]{2,3,0,1,4};
//        int[] ints = new int[]{2,3,1,1,4};
        int[] ints = new int[]{1,2,3};
        System.out.println(solution45.jump(ints));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
