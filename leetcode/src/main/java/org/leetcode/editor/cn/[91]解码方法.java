package org.leetcode.editor.cn;//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 👍 1044 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution91 {
    public int numDecodings(String s) {
        int length = s.length();
        byte[] arrays = s.getBytes();
        int[] ints = new int[arrays.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = arrays[i]-48;
        }
        if(ints[0] == 0){
            return 0;
        }
        if(length == 1){
            return 1;
        }
        //p 0~i-2有多少种解法，q是0~i-1有多少种解法，r是i-1~i有多少种解法,当前cur
        int p = 1,q,cur;
        if(ints[1]>0 && ints[0] * 10 + ints[1] < 27){
            q = 2;
        }else if(ints[1] == 0 && ints[0] * 10 + ints[1] > 26){
            return 0;
        }else {
            q = 1;
        }
        cur = q;
        int pre = 1;
        for (int i = 2; i < ints.length; i++) {
            if(ints[i-1] == 0){
                if(ints[i] == 0){
                    return 0;
                }
            }else{
                int value = ints[i - 1] * 10 + ints[i];
                if (ints[i] == 0){
                    if(value > 26){
                        return 0;
                    }
                    pre *= p;
                    cur = q = p = 1;
                }else if (value < 27){
                    cur = q + p;
                    p = q;
                    q = cur;
                }else {
                    pre *= q;
                    cur = q = p = 1;
                }
            }
        }
//        System.out.println(pre * cur);
        return pre * cur;
    }
}
class Main91{
    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        solution91.numDecodings("230");
//        solution91.numDecodings("207");
//        solution91.numDecodings("110");
//        solution91.numDecodings("123123");
//        solution91.numDecodings("11106");
//        solution91.numDecodings("11111");
//        solution91.numDecodings("1111");
//        solution91.numDecodings("226");
//        solution91.numDecodings("1201234");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
