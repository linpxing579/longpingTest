//快乐数
//happy-number
//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 592 👎 0

package Leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

class P202快乐数 {
    public static void main(String[] args) {
        Solution solution = new P202快乐数().new Solution();
        // TO TEST
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            List<Integer> list = Arrays.asList(1, 4, 16, 37, 58, 89, 145, 42, 20);
            while (!list.contains(n)) {
                int temp = 0;
                while (n != 0) {
                    temp += Math.pow(n % 10, 2);
                    n = n / 10;
                }
                n = temp;
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}