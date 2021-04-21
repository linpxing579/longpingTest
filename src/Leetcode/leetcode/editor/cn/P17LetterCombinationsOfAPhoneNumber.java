//Java：//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
// 示例 1：
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 示例 2：
//输入：digits = ""
//输出：[]
// 示例 3：
//输入：digits = "2"
//输出：["a","b","c"]

// 提示：
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1264 👎 0

package Leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] chars = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            return combinations(result, digits);
        }


        public List<String> combinations(List<String> list, String digits) {
            if ("".equals(digits)) {
                return list;
            }
            char c = digits.charAt(0);
            char[] aChar = chars[c - '0'];
            List<String> newList = new ArrayList<>();
            for (char c1 : aChar) {
                if (list.isEmpty()) {
                    newList.add(String.valueOf(c1));
                } else {
                    for (String s : list) {
                        newList.add(s + c1);
                    }
                }
            }
            return combinations(newList, digits.substring(1, digits.length()));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}