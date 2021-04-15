package Leetcode;

import java.util.*;

public class Test {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int count = 0;
        int i1 = 0;
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = index; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i1++] = nums1[i];
                    index = j + 1;
                    break;
                }
            }
        }
        return Arrays.copyOf(result, count);
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int index = digits.length;
        int plus = 1;
        for (int i = digits.length - 1; i > -1; i--) {
            int sum = digits[i] + plus;
            plus = sum / 10;
            result[index--] = sum % 10;
        }

        if (plus == 1) {
            result[0] = 1;
            return result;
        }
        return Arrays.copyOfRange(result, 1, result.length);
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[index++] = nums[i];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

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

    public boolean isValidSudoku(char[][] board) {

        char[][] heng = new char[9][10];
        char[][] shu = new char[9][10];
        char[][] fang = new char[9][10];
        int index;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }
                int i1 = board[i][j] - '0';
                if (heng[i][i1] != 0) {
                    return false;
                }
                heng[i][i1] = 1;

                if (shu[i][i1] != 0) {
                    return false;
                }
                shu[i][i1] = 1;

                if (i < 3 && j < 3) {
                    index = 1;
                } else if (i < 3 && j < 6) {
                    index = 2;
                } else if (i < 3) {
                    index = 3;
                } else if (i < 6 && j < 3) {
                    index = 4;
                } else if (i < 6 && j < 6) {
                    index = 5;
                } else if (i < 6) {
                    index = 6;
                } else if (j < 3) {
                    index = 7;
                } else if (j < 6) {
                    index = 8;
                } else {
                    index = 9;
                }
                if (fang[index - 1][i1] != 0) {
                    return false;
                }
                fang[index - 1][i1] = 1;
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        //(i,j) (j,n-i+1)
/*        给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

        原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]*/
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = 0;
                int value = matrix[i][j];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    int tempRomw = row;
                    row = col;
                    col = n - tempRomw - 1;
                    temp = matrix[row][col];
                    matrix[row][col] = value;
                    value = temp;
                }

            }
        }
    }

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[len - i - 1];
            s[len - i - 1] = s[i];
            s[i] = temp;
        }
    }

    // 方法太差
    public int reverse(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));
        String reverse = s.reverse().toString();
        if (x < 0) {
            reverse = reverse.replace("-", "");
            reverse = "-" + reverse;
        }

        try {
            return Integer.valueOf(reverse.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    //蠢
    public int firstUniqChar(String s) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (temp[index] > 0) {
                temp[index] = -1;
            }
            if (temp[index] == 0) {
                temp[index] = i + 1;
            }
        }
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (temp[i] > 0 && temp[i] - 1 < index) {
                index = temp[i] - 1;
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        //蠢
        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }

        return true;
    }

    //大小写相差32，转换可以使用二进制或与32
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if ((str.charAt(0) < '0' || str.charAt(0) > '9') && str.charAt(0) != '-' && str.charAt(0) != '+') return 0;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c < '0' || c > '9') && !(s.length() == 0 && (c == '-' || c == '+'))) {
                break;
            }
            s.append(c);
        }
        if (s.length() == 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) return 0;
        long l = Long.parseLong(s.toString());
        if (l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) l;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String result = "1";
        for (int i = 2; i <= n; i++) {
            int count = 1;
            char c = result.charAt(0);
            StringBuilder temp = new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if (c == result.charAt(j)) {
                    count += 1;
                } else {
                    temp.append(count).append(c);
                    count = 1;
                    c = result.charAt(j);
                }
            }
            if (c == result.charAt(result.length() - 1)) {
                temp.append(count).append(c);
            }
            result = temp.toString();
        }
        return result;

        //1
        //11
        //21
        //1211
        //111221
        //312211
        //13112221
        //1113213211
        //31131211131221
        //13211311123113112211
        //11131221
        //31121122
        //1321122122
        //1113


    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].equals("")) {
            return "";
        }
        char c = strs[0].charAt(0);
        String shortStr = strs[0];
        for (int i = 1; i < strs.length; i++) {

            if (strs[i].equals("") || strs[i].charAt(0) != c) {
                return "";
            }
            if (shortStr.length() > strs[i].length()) {
                shortStr = strs[i];
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (shortStr.charAt(i) != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(shortStr.charAt(i));
        }
        return result.toString();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //坑
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //错误，双链表
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode head2 = head;
        while (head2 != null) {
            count += 1;
            head2 = head2.next;
        }
        head2 = head;
        int index = 0;
        while (head2 != null) {
            if (index == count - n - 1) {
                head2.next = head2.next.next;
                break;
            }
            index += 1;
            head2 = head2.next;
        }

        return head;

        // index = 0 ,head2 = 1
        // index = 1 ,h = 2
        //index = 2, h = 3
    }

    public ListNode create() {
        ListNode head = new ListNode(1);
        ListNode head1 = head;
        for (int i = 2; i <= 5; i++) {
            head1.next = new ListNode(i);
            head1 = head1.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = null;
        ListNode next;
        while (temp != null) {
            next = temp.next;
            temp.next = head;
            head = temp;
            temp = next;
        }
        return head;
    }

    //垃圾
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode first = null;
        if (l1.val > l2.val) {
            first = l2;
            l2 = l2.next;
        } else {
            first = l1;
            l1 = l1.next;
        }
        ListNode head = first;
        ListNode cur;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                cur = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                cur = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                cur = new ListNode(l1.val);
                l1 = l1.next;
            }
            first.next = cur;
            first = cur;
        }

        return head;
    }

    //慢
    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int j = list.size() - 1;
        int i = 0;
        while (i <= j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //同环赛跑问题
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == Integer.MIN_VALUE) {
                return true;
            }
            head.val = Integer.MIN_VALUE;
            head = head.next;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int c1 = maxDepth(root.left);
        int c2 = maxDepth(root.right);
        return Math.max(c1, c2) + 1;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (min != null && val <= min) return false;
        if (max != null && val >= max) return false;

        if (!helper(root.left, min, val)) return false;
        if (!helper(root.right, val, max)) return false;
        return true;
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return false;
        }
        return comRoot(root.left, root.right);
    }
    public static boolean comRoot(TreeNode left, TreeNode right){
        if(left == null){
            return right == null;
        }
        if(right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        levelOrder2(list, root, 0);
        return list;
    }

    public void levelOrder2(List<List<Integer>> result, TreeNode root, int index){

        if (root == null) return;
        if (result.size() < index + 1) {
            result.add(new ArrayList<>());
        }
        result.get(index).add(root.val);
        levelOrder2(result, root.left, index+1);
        levelOrder2(result, root.right, index+1);
    }

    //[-10,-3,0,5,9],
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int from, int to) {
        if ( from > to) return null;
        int mid = (from + to) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, from, mid - 1);
        root.right = helper(nums, mid + 1, to);
        return root;
    }

    public TreeNode helper2(int[] nums, int from, int to) {
        if (from > to) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (from + to) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper2(nums, from, mid - 1);
        root.right = helper2(nums, mid + 1, to);
        return root;
    }

    public TreeNode createTree() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        return treeNode;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        m = m - 1;
        n = n - 1;
        while (n >= 0 && m >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m];
                nums1[m] = 0;
                m--;
            } else {
                nums1[index--] = nums2[n];
                n--;
            }
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
        while (m >= 0) {
            nums1[index--] = nums1[m--];
        }
    }

    public boolean isBadVersion(int version) {
        if (version >= 5) {
            return true;
        }
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int half = 0;
        while (left < n) {
            half = left + (n - left) / 2;
            if (isBadVersion(half)) {
                n = half;
            } else {
                left = half + 1;
            }
        }
        return left;
    }


    // 1 1
    //2 (1,1) (2)
    //f(n) = f(n -1) + f(n - 2)
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    //f(n) = max(f(n- 1) + n , n)
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    //f(n) = max(f(n -2), f(n -3) )
    //f(n) = max(f(n -2) + n , f(n-1))
    public int rob(int[] nums) {
        int length = nums.length;
        int max = 0;
        int[] total = new int[length];
        for (int i = 0; i < length; i++) {
            int t2 = i - 2 >= 0 ? total[i - 2] : 0;
            int t3 = i - 3 >= 0 ? total[i - 3] : 0;
            int to = Math.max(t2, t3) + nums[i];
            total[i] = to;
            max = Math.max(max, to);
        }
        return max;
    }


    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

    // 判断整数 n 是否是素数
    public boolean isPrim(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int c = 0;
        for (c = 0; c < xor; c++) {
            xor &= (xor - 1);
        }
        return c;
    }

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rows;
        for (int i = 1; i <= numRows; i++) {
            rows = new ArrayList<>();
            rows.add(1);
            for (int j = 1; j < i - 1; j++) {
                rows.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
            }
            if (i != 1) rows.add(1);
            result.add(rows);
        }
        return result;
    }


    public int missingNumber(int[] nums) {

        int n = nums.length + 1;
        int[] flag = new int[n];
        for (int num : nums) {
            flag[num] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber1(int[] nums){
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
            res = res ^ i;
        }
        return res;
    }

    /**
     * Description: 两个有序数组，求中位数
     * @author linpxing
     * @param nums1: 数组1
     * @param nums2: 数组2
     * @return: double 中位数
     **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int midd = (m + n) / 2;
        midd = (m + n) % 2 == 0 ? midd - 1 : midd;
        int count = (m + n) % 2== 0 ? 2 : 1;
        double result = 0;
        for (int index = 0, i = 0, j= 0; index < n + m; index++) {
            int num = 0;
            if (i >= m) {
                num = nums2[j++];
            } else if (j >= n) {
                num = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                num = nums2[j++];
            } else {
                num = nums1[i++];
            }
            if (index == midd) {
                result += num;
                count --;
                if (count > 0) {
                    midd ++;
                } else {
                    break;
                }
            }
        }
        return (m + n) % 2 ==0 ? (result/2) : result;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        char[][] re = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//        test.isValidSudoku(re);
//        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        test.rotate(ints);

//        System.out.println(test.reverse(-123));
//        System.out.println(test.firstUniqChar("dabbcb"));
//        System.out.println(0xdf);
//        System.out.println(test.myAtoi("42"));
//        System.out.println(test.myAtoi("2147483648"));
//        System.out.println(Integer.MAX_VALUE);

//        System.out.println(test.countAndSay(1));
//        System.out.println(test.removeNthFromEnd(test.create(),2));
//        System.out.println(test.isValidBST(test.createTree()));
//        System.out.println(test.firstBadVersion(5));
//        System.out.println(test.climbStairs(4));
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(test.maxSubArray(nums));
//        int[] nums = new int[]{1, 2, 3, 1};
//        int[] nums2 = new int[]{2, 7, 9, 3, 1};
//        System.out.println(test.rob(nums));
//        System.out.println(test.isPowerOfThree(27));
//        System.out.println(Integer.toString(-3, 2));
//        System.out.println(test.hammingWeight(-3));
//        System.out.println(test.hammingDistance(1, 4));
//        System.out.println(test.generate(4));
        System.out.println(test.levelOrder(test.createTree()));
    }


}
