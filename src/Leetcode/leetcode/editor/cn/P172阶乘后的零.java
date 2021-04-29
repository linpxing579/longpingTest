//阶乘后的零
//factorial-trailing-zeroes
//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 454 👎 0

package Leetcode.leetcode.editor.cn;

class P172阶乘后的零{
    public static void main(String[] args) {
        Solution solution = new P172阶乘后的零().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        return  n / 5 + trailingZeroes(n /5 );
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}