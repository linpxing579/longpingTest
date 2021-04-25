//最后一个单词的长度
//length-of-last-word
//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 308 👎 0

package Leetcode.leetcode.editor.cn;

class P58最后一个单词的长度 {
    public static void main(String[] args) {
        Solution solution = new P58最后一个单词的长度().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if ("".equals(s)) return 0;
            int result = 0;
            int index = s.length() - 1;
            while (index >= 0 && s.charAt(index) == ' ') {
                index--;
            }
            while (index >= 0) {
                if (s.charAt(index) == ' ') {
                    break;
                }
                result++;
                index--;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}