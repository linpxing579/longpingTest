//两数之和
//two-sum
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10867 👎 0

package Leetcode.leetcode.editor.cn;

import com.lpmas.framework.util.JsonKit;

import java.util.HashMap;
import java.util.Map;

class P1两数之和 {
    public static void main(String[] args) {
        Solution solution = new P1两数之和().new Solution();
        // TO TEST
        System.out.println(JsonKit.toJson(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(JsonKit.toJson(solution.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(JsonKit.toJson(solution.twoSum(new int[]{3, 3}, 6)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    return result;
                }
                int re = target - nums[i];
                if (map.containsKey(re)) {
                    continue;
                }
                map.put(re, i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}