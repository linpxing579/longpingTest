//最长回文子串
//longest-palindromic-substring
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3555 👎 0

package Leetcode.leetcode.editor.cn;

class P5最长回文子串 {
    public static void main(String[] args) {
        Solution solution = new P5最长回文子串().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
        System.out.println(solution.longestPalindrome("abb"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() < 2) return s;
            int left = 0, right = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {

                int len1 = expand(chars, i, i);
                int len2 = expand(chars, i, i + 1);
                int len = Math.max(len1, len2);
                if (right - left + 1 < len) {
                    left = i - (len - 1) / 2;
                    right = i + (len / 2);
                }
            }

            return s.substring(left, right + 1);
        }

        public int expand(char[] chars, int left, int right) {
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
            }

            //(right - 1) - (left - 1) + 1
            return right - left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}