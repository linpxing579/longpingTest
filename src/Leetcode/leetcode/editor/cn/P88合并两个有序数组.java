//合并两个有序数组
//merge-sorted-array
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 931 👎 0

package Leetcode.leetcode.editor.cn;

import java.util.Arrays;

class P88合并两个有序数组{
    public static void main(String[] args) {
        Solution solution = new P88合并两个有序数组().new Solution();
        // TO TEST
       solution.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        // while (i < nums1.length || j < n) {
        //     if (i >= m) {
        //         nums1[i++] = nums2[j++];
        //     } else if (j >= n) {
        //         break;
        //     } else if (nums1[i] < nums2[j]) {
        //         i++;
        //     } else {
        //         int temp = nums1[i];
        //         nums1[i] = nums2[j];
        //         nums2[j] = temp;
        //         i++;
        //     }
        // }
        int[] result = Arrays.copyOf(nums1, m);
        for (int index = 0; index < nums1.length; index++) {
            if (i >= m) {
                nums1[index] = nums2[j++];
            } else if (j >= n) {
                nums1[index] = result[i++];
            } else if (result[i] < nums2[j]) {
                nums1[index] = result[i++];
            } else {
                nums1[index] = nums2[j++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}