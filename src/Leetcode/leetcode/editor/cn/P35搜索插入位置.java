//搜索插入位置
//search-insert-position
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 894 👎 0

package Leetcode.leetcode.editor.cn;

import java.util.Arrays;

class P35搜索插入位置 {
    public static void main(String[] args) {
        Solution solution = new P35搜索插入位置().new Solution();
        // TO TEST
        // System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
        // System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
        // System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(solution.searchInsert(new int[]{2,3,5,6,9}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return searchInsert2(nums, target, 0, nums.length - 1);
        }

        public int searchInsert2(int[] nums, int target, int left, int right) {
            if (nums[left] >= target) return left;
            if (nums[right] == target) return right;
            if (nums[right] < target) return right + 1;
            int midd = (left + right + 1) / 2;
            if (nums[midd] == target) {
                return midd;
            } else if (nums[midd] > target) {
              return searchInsert2(nums, target, left, midd - 1);
            } else {
              return searchInsert2(nums, target, midd + 1, right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}