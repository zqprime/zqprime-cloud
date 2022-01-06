package org.leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1950 👎 0


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String commonStr = strs[0];
        byte[] bytes = commonStr.getBytes();
        int th = bytes.length;
        for (int i = 1; i < strs.length && th > 0; i++) {
            while (true){
                if(strs[i].startsWith(new String(bytes, 0, th)) || th <= 0){
                    break;
                }else {
                    th--;
                }
            }
        }
        return new String(bytes,0,th);
    }
}
class Main14{
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog","racecar","car"};
        String prefix = solution14.longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
