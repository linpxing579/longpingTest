//对称二叉树
//symmetric-tree
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1359 👎 0

package Leetcode.leetcode.editor.cn;

class P101对称二叉树 {
    public static void main(String[] args) {
        Solution solution = new P101对称二叉树().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {

            if (root == null) {
                return false;
            }
            return comRoot(root.left, root.right);
        }

        public boolean comRoot(TreeNode left, TreeNode right) {
            if (left == null) {
                return right == null;
            }
            if (right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            return comRoot(left.left, right.right) && comRoot(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}