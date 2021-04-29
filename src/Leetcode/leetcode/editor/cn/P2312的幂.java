//2的幂
//power-of-two
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 313 👎 0

package Leetcode.leetcode.editor.cn;

class P2312的幂{
    public static void main(String[] args) {
        Solution solution = new P2312的幂().new Solution();
        // TO TEST
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(2));
        System.out.println(solution.isPowerOfTwo(4));
        System.out.println(solution.isPowerOfTwo(10));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(32));
        System.out.println(solution.isPowerOfTwo(218));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == Integer.MAX_VALUE || n == Integer.MIN_VALUE) return false;
        int cap = n - 1;
        cap |= cap >>> 1;
        cap |= cap >>> 2;
        cap |= cap >>> 4;
        cap |= cap >>> 8;
        cap |= cap >>> 16;
        return n == cap + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}