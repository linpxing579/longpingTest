//二进制求和
//add-binary
//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 602 👎 0

package Leetcode.leetcode.editor.cn;

class P67二进制求和 {
    public static void main(String[] args) {
        Solution solution = new P67二进制求和().new Solution();
        // TO TEST

        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int max = Math.max(a.length(), b.length());
            char[] arr = new char[max + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = '0';
            }
            int i = a.length() - 1, j = b.length() - 1, index = max;
            while (i >= 0 || j >= 0) {
                int temp = 0;
                if (i < 0) {
                    temp = (b.charAt(j--) - '0') + (arr[index] - '0');
                } else if (j < 0) {
                    temp = (a.charAt(i--) - '0') + (arr[index] - '0');
                } else {
                    temp = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + (arr[index] - '0');
                }
                if (temp == 3) {
                    arr[index - 1] = '1';
                    arr[index] = '1';
                } else if (temp == 2) {
                    arr[index - 1] = '1';
                    arr[index] = '0';
                } else if (temp == 1) {
                    arr[index] = '1';
                } else {
                    arr[index] = '0';
                }
                index--;
            }

            String result = String.valueOf(arr);
            return arr[0] == '0' ? result.substring(1, result.length()): result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}