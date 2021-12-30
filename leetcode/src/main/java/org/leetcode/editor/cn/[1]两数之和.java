package org.leetcode.editor.cn;//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
//
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
// Related Topics 数组 哈希表 👍 12986 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    public static void main(String[] args) {
//        int[] arr = {7,9,4,5,2,6,3,8,1};
        int[] arr = {3,3};
        Solution1 solution = new Solution1();
        int[] ints = solution.twoSum2(arr, 6);
        System.out.println(Arrays.toString(ints));
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int[] ints = map.get(nums[i]);
                if(ints[1]<0){
                    ints[1] = i;
                }
            }else {
                map.put(nums[i],new int[]{i,-1});
            }
        }
       int index1 = 0,index2 = 1;
       for (int i = 0; i < nums.length; i++) {
           int t = target - nums[i];
           index1 = i;
           if(map.containsKey(t)){
                if(t == nums[i]){
                    int[] ints = map.get(t);
                    if(ints[1] > 0){
                        index2 = ints[1];
                        break;
                    }
                }else {
                    index2 = map.get(t)[0];
                    break;
                }
           }
       }
        return new int[]{index1,index2};
    }



    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0,nums.length);
        sort(nums);
        int index1,index2 = -1;
        //得到有序数组，以便使用二分法
        root:for (index1 = 0; index1 < nums.length; index1++) {
            int t = target - nums[index1];
            int startIndex = index1+1;
            while (startIndex < nums.length){
                if((index2 = twoFind(nums,t,startIndex)) > 0){
                    break root;
                }
                startIndex ++;
            }
        }
        int one = nums[index1],two = nums[index2];
        index1 = -1; index2 = -1;
        boolean getOne = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == one && !getOne){
                getOne = true;
                index1 = i;
            }
            if(arr[i] == two){
                if(i == index1){
                    continue;
                }
                index2 = i;
                if(getOne){
                    break;
                }
            }
        }
        return new int[]{index1,index2};
    }

    public static void sort(int []arr){
        int length = arr.length;
        for (int step = length/2; step >= 1; step /= 2){
            for (int i = step; i < length; i++){
                int temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp){
                    arr[j+step] = arr[j];
                    j -= step;
                }
                arr[j+step] = temp;
            }
        }
    }

    /**
     * 二分查找
     */
    public int twoFind(int[] nums, int target,int startIndex){
        int between = startIndex + (nums.length-1-startIndex)/2;
        int endIndex = nums.length-1;
        while (nums[between] != target){
            if(startIndex == between){
                return -1;
            }
            if(nums[between] > target ){
                endIndex = between;
            }else {
                startIndex = between;
            }
            between = startIndex + (endIndex-startIndex)/2;
        }
        return between;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
