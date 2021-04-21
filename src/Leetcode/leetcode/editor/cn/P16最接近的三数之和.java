//最接近的三数之和
//3sum-closest
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 756 👎 0

package Leetcode.leetcode.editor.cn;

import java.util.Arrays;

class P16最接近的三数之和 {
    public static void main(String[] args) {
        Solution solution = new P16最接近的三数之和().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int result = Integer.MAX_VALUE;
            int length = nums.length;
            Arrays.sort(nums);
            for (int i = 0; i < length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = length - 1;
                while (left < right) {
                    int temp = nums[i] + nums[left] + nums[right];
                    if (nums[i] + nums[left] + nums[right] == target) {
                        return target;
                    }
                    int abs = Math.abs(target - temp);
                    int abs1 = Math.abs(target - result);
                    if (Math.abs(target - temp) < Math.abs(target - result)) {
                        result = temp;
                    }
                    if (target > temp) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}