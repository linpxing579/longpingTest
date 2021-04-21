//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3257 👎 0

package Leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 2; i++) {
                if (i != 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                for (int j = i + 1; j < length - 1; j++) {
                    if (nums[i] + nums[j] > 0) {
                        break;
                    }
                    if (j >= i + 2&& nums[j] == nums[j -1]) {
                        continue;
                    }
                    for (int k = length - 1; k > j; k--) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            break;
                        } else if ((nums[i] + nums[j]) * -1 > nums[k]) {
                            break;
                        }
                    }
                }
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}